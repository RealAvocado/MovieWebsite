package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.BasicMovieInfoService;
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

    @PostMapping(path = "{country}")
    public void registerMovieInfoByCountry(@PathVariable String country) {
        try {
            basicMovieInfoService.addMovieInfoByCountry(country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "test/{country}")
    public void registerMovieInfoByCountryTest(@PathVariable String country) {
        try {
            basicMovieInfoService.addMovieInfoByCountryTest(country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "all")
    public void registerAllMovieInfo() {
        try {
            basicMovieInfoService.addAllMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "{imdbID}")
    public void deleteMovieInfo(@PathVariable String imdbID) {
        basicMovieInfoService.deleteMovieInfo(imdbID);
    }

    @PutMapping(path = "{newTitle},{imdbID}")
    public void updateMovieName(@PathVariable String newTitle, @PathVariable String imdbID) {
        basicMovieInfoService.updateMovieName(newTitle, imdbID);
    }
}
