package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCastPair;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;

import java.util.List;

public interface MovieCastPairService {
    public List<MovieCastPair> getMoviesByCast(String cast);
    public void insertMovieCastPairFromOneMovie(Movie movie);
}
