package com.example.moviewebsite.movie_package;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_package.objectsFromJson.movie.Movie;
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

    public static void registerData() throws IOException, InterruptedException {

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int page = 0;
        for (int p = 0; p < 299; p++) {
            page++;
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=us&services=netflix%2Cprime%2Cdisney&type=movie&order_by=imdb_vote_count&page=" + page + "&desc=true&language=en&output_language=en";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                    .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            //split a large sets of json into an array
            String json = response.body().substring(11, response.body().length() - 19);
            List<Movie> movieList = new ArrayList<>();
            JSONArray arr = JSON.parseArray(json);

            for (int i = 0; i < arr.size(); i++) {
                ObjectMapper mapper = new ObjectMapper();
                movieList.add(mapper.readValue(arr.getString(i), Movie.class));
            }

            for (Movie movie : movieList) {
                System.out.print("Title: "
                        + movie.getOriginalTitle()
                        + "; poster of 780 size: "
                        + movie.getPosterURLs().get780()
                        + "; cast: " + movie.getCast());
                if (movie.getStreamingInfo().getNetflix()!=null){
                    System.out.print("; netflix link: " + movie.getStreamingInfo().getNetflix().getUs().getLink());
                }
                if (movie.getStreamingInfo().getPrime()!=null){
                    System.out.print("; prime link: " + movie.getStreamingInfo().getPrime().getUs().getLink());
                }
                if (movie.getStreamingInfo().getDisney()!=null){
                    System.out.print("; disney link: " + movie.getStreamingInfo().getDisney().getUs().getLink());
                }
                System.out.println();
                System.out.println();
            }
        }

        /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://streaming-availability.p.rapidapi.com/search/ultra?country=us&services=netflix%2Cprime%2Cdisney&type=movie&order_by=imdb_vote_count&page=1&desc=true&language=en&output_language=en"))
                .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        //split a large sets of json into an array
        String json = response.body().substring(11, response.body().length() - 19);
        List<Movie> movieList = new ArrayList<>();
        JSONArray arr = JSON.parseArray(json);

        for (int i = 0; i < arr.size(); i++) {
            ObjectMapper mapper = new ObjectMapper();
            movieList.add(mapper.readValue(arr.getString(i), Movie.class));
        }

        for (Movie movie : movieList) {
            System.out.print("Title: "
                    + movie.getOriginalTitle()
                    + "; poster of 780 size: "
                    + movie.getPosterURLs().get780()
                    + "; cast: " + movie.getCast());
            if (movie.getStreamingInfo().getNetflix()!=null){
                System.out.print("; netflix link: " + movie.getStreamingInfo().getNetflix().getUs().getLink());
            }
            if (movie.getStreamingInfo().getPrime()!=null){
                System.out.print("; prime link: " + movie.getStreamingInfo().getPrime().getUs().getLink());
            }
            if (movie.getStreamingInfo().getDisney()!=null){
                System.out.print("; disney link: " + movie.getStreamingInfo().getDisney().getUs().getLink());
            }
            System.out.println();
            System.out.println();
        }*/

    }

}
