package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCastPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl.MovieCastPairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/cast_of_movie")
public class MovieCastPairController {

    private final MovieCastPairServiceImpl movieCastPairServiceImpl;

    @Autowired
    public MovieCastPairController(MovieCastPairServiceImpl movieCastPairServiceImpl) {
        this.movieCastPairServiceImpl = movieCastPairServiceImpl;
    }

    @GetMapping(path = "{cast}")
    public List<MovieCastPair> getMoviesByCast(@PathVariable String cast) {
        return movieCastPairServiceImpl.getMoviesByCast(cast);
    }
}
