package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.dto.SearchParam;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import org.springframework.data.domain.Page;

public interface SearchMovieService {

    Page<BasicMovieInfo> search(SearchParam searchParam);

}
