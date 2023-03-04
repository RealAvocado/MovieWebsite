package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.BasicMovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @PostMapping(path = "{country}")
    public void registerMovieInfo(@PathVariable String country) throws IOException, InterruptedException {
        basicMovieInfoService.addMovieInfo(country);
    }

    @DeleteMapping(path = "{imdbID}")
    public void deleteMovieInfo(@PathVariable String imdbID){
        basicMovieInfoService.deleteMovieInfo(imdbID);
    }

    @PutMapping(path = "{newTitle},{imdbID}")
    public void updateMovieName(@PathVariable String newTitle, @PathVariable String imdbID){
        basicMovieInfoService.updateMovieName(newTitle, imdbID);
    }
}
