package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl.MovieCountryPairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/country_of_movie")
public class MovieCountryPairController {
    private final MovieCountryPairServiceImpl movieCountryPairServiceImpl;

    @Autowired
    public MovieCountryPairController(MovieCountryPairServiceImpl movieCountryPairServiceImpl) {
        this.movieCountryPairServiceImpl = movieCountryPairServiceImpl;
    }

    @GetMapping(path = "{country}")
    public List<MovieCountryPair> getMoviesByCountry(@PathVariable String country) {
        return movieCountryPairServiceImpl.getMoviesByCountry(country);
    }
}
