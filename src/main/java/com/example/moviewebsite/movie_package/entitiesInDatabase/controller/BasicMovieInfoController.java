package com.example.moviewebsite.movie_package.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_package.entitiesInDatabase.service.BasicMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/basicInfo")
public class BasicMovieInfoController {
    private final BasicMovieInfoService basicMovieInfoService;

    @Autowired
    public BasicMovieInfoController(BasicMovieInfoService basicMovieInfoService) {
        this.basicMovieInfoService = basicMovieInfoService;
    }

    @GetMapping(path = "{movieTitle}")
    public List<BasicMovieInfo> getMovieInfoByTitle(@PathVariable("movieTitle") String movieTitle) {
        return basicMovieInfoService.getMovieInfoByTitle(movieTitle);
    }

    @GetMapping(path = "{language}")
    public List<BasicMovieInfo> getMovieInfoByLanguage(@PathVariable("language") String language) {
        return basicMovieInfoService.getMovieInfoByLanguage(language);
    }

    @PostMapping
    public void registerMovieInfo() {
        basicMovieInfoService.addMovieInfo();
    }
}
