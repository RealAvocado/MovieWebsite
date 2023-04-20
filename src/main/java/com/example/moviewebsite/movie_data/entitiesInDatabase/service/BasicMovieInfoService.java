package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;

import java.util.List;

public interface BasicMovieInfoService {
    public List<BasicMovieInfo> getMovieInfoByTitle(String movieTitle);
    public List<BasicMovieInfo> getMovieInfoByLanguage(String language);
    public List<BasicMovieInfo> getMovieInfoByYear(String year);
    public List<BasicMovieInfo> getMovieInfoByGenre(Integer genres);
    public void addMovieInfoByCountry(String country, String service) throws Exception;
    public void addMovieInfoFromSingleJson(String json);
    public void addAllMovies() throws Exception;
    public void saveMovieInfo(Movie movie);
    public void updateStreamingLinks(Movie movie);
    public void deleteMovieInfo(String imdbID);
    public void updateMovieName(String newTitle, String imdbID);

}
