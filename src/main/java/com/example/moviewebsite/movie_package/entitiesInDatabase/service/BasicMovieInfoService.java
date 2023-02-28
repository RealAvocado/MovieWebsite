package com.example.moviewebsite.movie_package.entitiesInDatabase.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_package.entitiesInDatabase.repository.BasicMovieInfoRepository;
import com.example.moviewebsite.movie_package.objectsFromJson.movie.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicMovieInfoService {
    private final BasicMovieInfoRepository basicMovieInfoRepository;

    @Autowired
    public BasicMovieInfoService(BasicMovieInfoRepository basicMovieInfoRepository) {
        this.basicMovieInfoRepository = basicMovieInfoRepository;
    }

    public List<BasicMovieInfo> getMovieInfoByTitle(String movieTitle) {
        return basicMovieInfoRepository.findBasicMovieInfoByOriginalTitle(movieTitle);
    }

    public List<BasicMovieInfo> getMovieInfoByLanguage(String language) {
        return basicMovieInfoRepository.findBasicMovieInfoByLanguage(language);
    }

    public void addMovieInfo() throws IOException, InterruptedException {

    }

}
