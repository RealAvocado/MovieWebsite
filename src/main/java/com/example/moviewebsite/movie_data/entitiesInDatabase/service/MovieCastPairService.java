package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCastPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCastPairRepository;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieCastPairService {
    private final MovieCastPairRepository movieCastPairRepository;

    @Autowired
    public MovieCastPairService(MovieCastPairRepository movieCastPairRepository) {
        this.movieCastPairRepository = movieCastPairRepository;
    }

    public List<MovieCastPair> getMoviesByCast(String cast) {
        return movieCastPairRepository.findMovieCastPairByCast(cast);
    }

    public void insertMovieCastPairFromOneMovie(Movie movie){
        for (String cast : movie.getCast()) {
            MovieCastPair movieCastPair = new MovieCastPair(movie.getImdbID(), cast);
            Optional<MovieCastPair> movieCastPairOptional = movieCastPairRepository.findMovieCountryPairByCastAndImdbID(cast, movie.getImdbID());
            if (movieCastPairOptional.isEmpty()) {
                movieCastPairRepository.save(movieCastPair);
            }
        }
    }
}
