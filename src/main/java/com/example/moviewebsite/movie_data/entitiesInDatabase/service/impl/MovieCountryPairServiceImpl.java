package com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCountryPairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.MovieCountryPairService;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieCountryPairServiceImpl implements MovieCountryPairService {
    private final MovieCountryPairRepository movieCountryPairRepository;

    @Autowired
    public MovieCountryPairServiceImpl(MovieCountryPairRepository movieCountryPairRepository) {
        this.movieCountryPairRepository = movieCountryPairRepository;
    }

    public List<MovieCountryPair> getMoviesByCountry(String country) {
        return movieCountryPairRepository.findMovieCountryPairByCountry(country);
    }

    @Transactional
    public void insertMovieCountryPairFromOneMovie(Movie movie) {
        Optional<MovieCountryPair> movieCountryPairOptional = movieCountryPairRepository.findMovieCountryPairByImdbID(movie.getImdbID());
        if (movieCountryPairOptional.isEmpty()) {
            for (String country : movie.getCountries()) {
                MovieCountryPair movieCountryPair = new MovieCountryPair(movie.getImdbID(), country);
                movieCountryPairRepository.save(movieCountryPair);
            }
        }

    }
}
