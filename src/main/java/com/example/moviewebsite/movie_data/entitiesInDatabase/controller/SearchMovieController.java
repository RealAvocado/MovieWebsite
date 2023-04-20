package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.dto.SearchParam;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.SearchMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping(path = "api/movie")
public class SearchMovieController {

    private final SearchMovieService searchMovieService;

    @Autowired
    public SearchMovieController(SearchMovieService searchMovieService) {
        this.searchMovieService = searchMovieService;
    }

    @PostMapping(path="search")
    public Page<BasicMovieInfo> search(@RequestBody SearchParam searchParam){
        return searchMovieService.search(searchParam);
    }
}
