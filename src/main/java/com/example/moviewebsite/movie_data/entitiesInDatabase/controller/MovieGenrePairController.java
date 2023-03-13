package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.MovieGenrePairService;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/movie/genre")
public class MovieGenrePairController {
    private final MovieGenrePairService movieGenrePairService;

    @Autowired
    public MovieGenrePairController(MovieGenrePairService movieGenrePairService) {
        this.movieGenrePairService = movieGenrePairService;
    }

    @GetMapping(path = "{genre}")
    public List<MovieGenrePair> getMoviesByGenre(@PathVariable int genre){
        return movieGenrePairService.getMoviesByGenre(genre);
    }

//    @PostMapping
//    public void registerMovieGenrePairs(Movie movie) {
//        movieGenrePairService.insertMovieGenrePair(movie);
//    }
}
