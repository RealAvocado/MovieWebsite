package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieCountryPairRepository;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;

import java.util.List;

public interface MovieCountryPairService {
    public List<MovieCountryPair> getMoviesByCountry(String country);
    public void insertMovieCountryPairFromOneMovie(Movie movie);
}
