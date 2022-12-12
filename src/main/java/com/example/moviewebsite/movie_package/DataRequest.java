package com.example.moviewebsite.movie_package;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_package.movieEntity.movie.MovieRepository;
import com.example.moviewebsite.test.movieEntity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DataRequest {
    //private static Session movieRepository;
    private final MovieRepository movieRepository;

    //@Autowired

    public DataRequest(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://streaming-availability.p.rapidapi.com/search/pro?country=gb&service=netflix&type=movie&order_by=original_title&year_min=1960&year_max=2022&genre=18&page=1&desc=true&language=en&output_language=en")).header("X-RapidAPI-Key", "f96592562cmsh3f7abed7974f7c2p1235dbjsnc0c2ce7a1ead").header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        //split a large sets of json into an array
        String json = response.body().substring(11, response.body().length() - 18);
        List<Movie> movieList = new ArrayList<>();
        JSONArray arr = JSON.parseArray(json);

        for (int i = 0; i < arr.size(); i++) {
            ObjectMapper mapper = new ObjectMapper();
            Movie movie = mapper.readValue(arr.getString(i), Movie.class);
            //movieRepository.save(movie);
            movieList.add(mapper.readValue(arr.getString(i), Movie.class));
        }

        for (Movie movie : movieList) {
            System.out.println("Title: " + movie.getOriginalTitle() + "; poster of 780 size: " + movie.getPosterURLs().get780());
            System.out.println();
        }

    }

}
