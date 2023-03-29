package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;

import java.util.List;

public interface MovieGenrePairService {
    public List<MovieGenrePair> getMoviesByGenre(int genre);
    public void insertMovieGenrePairFromOneMovie (Movie movie);
}
