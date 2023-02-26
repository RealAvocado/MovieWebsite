package com.example.moviewebsite.movie_package.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_package.entitiesInDatabase.service.BasicMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path = "api/movie/basicInfo")
public class BasicMovieInfoController {
    private final BasicMovieInfoService basicMovieInfoService;

    @Autowired
    public BasicMovieInfoController(BasicMovieInfoService basicMovieInfoService) {
        this.basicMovieInfoService = basicMovieInfoService;
    }
}
