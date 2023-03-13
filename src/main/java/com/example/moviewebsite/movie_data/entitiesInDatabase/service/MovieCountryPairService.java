package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCountryPairRepository;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieCountryPairService {
    private final MovieCountryPairRepository movieCountryPairRepository;

    @Autowired
    public MovieCountryPairService(MovieCountryPairRepository movieCountryPairRepository) {
        this.movieCountryPairRepository = movieCountryPairRepository;
    }

    public List<MovieCountryPair> getMoviesByCountry(String country) {
        return movieCountryPairRepository.findMovieCountryPairByCountry(country);
    }

    public void insertMovieCountryPairFromOneMovie(Movie movie){
        for (String country : movie.getCountries()) {
            MovieCountryPair movieCountryPair = new MovieCountryPair(movie.getImdbID(), country);
            Optional<MovieCountryPair> movieCountryPairOptional = movieCountryPairRepository.findMovieCountryPairByCountryAndImdbID(country, movie.getImdbID());
            if (movieCountryPairOptional.isEmpty()) {
                movieCountryPairRepository.save(movieCountryPair);
            }
        }
    }
}
