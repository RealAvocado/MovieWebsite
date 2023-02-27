package com.example.moviewebsite.movie_package.entitiesInDatabase.service;

import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_package.entitiesInDatabase.repository.BasicMovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addMovieInfo() {

    }
}
