package com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieGenrePairRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.MovieGenrePairService;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieGenrePairServiceImpl implements MovieGenrePairService {
    private final MovieGenrePairRepository movieGenrePairRepository;

    @Autowired
    public MovieGenrePairServiceImpl(MovieGenrePairRepository movieGenrePairRepository) {
        this.movieGenrePairRepository = movieGenrePairRepository;
    }

    public List<MovieGenrePair> getMoviesByGenre(int genre) {
        return movieGenrePairRepository.findMovieGenrePairByGenre(genre);
    }

    @Transactional
    public void insertMovieGenrePairFromOneMovie (Movie movie){
        Optional<MovieGenrePair> movieGenrePairOptional = movieGenrePairRepository.findMovieGenrePairByImdbID(movie.getImdbID());
        if (movieGenrePairOptional.isEmpty()){
            for (Integer genre : movie.getGenres()) {
                MovieGenrePair movieGenrePair = new MovieGenrePair(movie.getImdbID(), genre);
                movieGenrePairRepository.save(movieGenrePair);
            }
        }
    }
}
