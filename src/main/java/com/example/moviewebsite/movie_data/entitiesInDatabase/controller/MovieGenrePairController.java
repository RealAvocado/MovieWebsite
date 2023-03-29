package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl.MovieGenrePairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/genre")
public class MovieGenrePairController {
    private final MovieGenrePairServiceImpl movieGenrePairServiceImpl;

    @Autowired
    public MovieGenrePairController(MovieGenrePairServiceImpl movieGenrePairServiceImpl) {
        this.movieGenrePairServiceImpl = movieGenrePairServiceImpl;
    }

    @GetMapping(path = "{genre}")
    public List<MovieGenrePair> getMoviesByGenre(@PathVariable int genre){
        return movieGenrePairServiceImpl.getMoviesByGenre(genre);
    }

//    @PostMapping
//    public void registerMovieGenrePairs(Movie movie) {
//        movieGenrePairService.insertMovieGenrePair(movie);
//    }
}
