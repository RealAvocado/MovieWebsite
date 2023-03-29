package com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCastPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCastPairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.MovieCastPairService;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieCastPairServiceImpl implements MovieCastPairService {
    private final MovieCastPairRepository movieCastPairRepository;

    @Autowired
    public MovieCastPairServiceImpl(MovieCastPairRepository movieCastPairRepository) {
        this.movieCastPairRepository = movieCastPairRepository;
    }

    public List<MovieCastPair> getMoviesByCast(String cast) {
        return movieCastPairRepository.findMovieCastPairByCast(cast);
    }

    @Transactional
    public void insertMovieCastPairFromOneMovie(Movie movie) {
        Optional<MovieCastPair> movieCastPairOptional = movieCastPairRepository.findMovieCountryPairByImdbID(movie.getImdbID());
        if (movieCastPairOptional.isEmpty()) {
            for (String cast : movie.getCast()) {
                MovieCastPair movieCastPair = new MovieCastPair(movie.getImdbID(), cast);
                movieCastPairRepository.save(movieCastPair);
            }
        }
    }
}
