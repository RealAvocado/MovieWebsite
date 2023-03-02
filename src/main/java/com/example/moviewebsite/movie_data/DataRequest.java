package com.example.moviewebsite.movie_data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class DataRequest {
    private List<Movie> movieList;

    public static<T extends JpaRepository<T, String>> void jpaRegisterData(int totalPages, String country) throws IOException, InterruptedException {
        int page = 0;
        for (int p = 0; p < totalPages; p++) {
            page++;
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=" + country + "&services=netflix%2Cprime%2Cdisney%2Cstarz&type=movie&order_by=imdb_vote_count&page=" + page + "&desc=true&language=en&output_language=en";
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
                try{
                    Movie movie = mapper.readValue(arr.getString(i), Movie.class);
                    movieList.add(movie);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            for (Movie movie : movieList) {
                System.out.print("Title: "
                        + movie.getOriginalTitle()
                        + "; poster of 780 size: "
                        + movie.getPosterURLs().get780()
                        + "; cast: " + movie.getCast()
                        + "; streaming info: " + movie.getStreamingInfo());
                System.out.println();
                System.out.println();
            }
        }
    }

    public static void registerDataDemo(String country) throws IOException, InterruptedException {
        int page = 1;
        int totalPages = 1;
        for (int p = 0; p < totalPages; p++) {
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=" +
                    country + "&services=netflix%2Cprime%2Cdisney%2Cstarz&type=movie&order_by=imdb_vote_count&page=" +
                    page + "&desc=true&language=en&output_language=en";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                    .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //get total pages amount
            if (p==0){
                int lastColonIndex = response.body().lastIndexOf(':');
                totalPages = Integer.parseInt(response.body().substring(lastColonIndex + 1, response.body().length()-1));
                System.out.println("total pages: " + totalPages);
            }

            //split a large sets of json into an array
            int lastCommaIndex = response.body().lastIndexOf(',');
            String json = response.body().substring(11, lastCommaIndex);
            List<Movie> movieList = new ArrayList<>();
            JSONArray arr = JSON.parseArray(json);

            for (int i = 0; i < arr.size(); i++) {
                ObjectMapper mapper = new ObjectMapper();
                try{
                    movieList.add(mapper.readValue(arr.getString(i), Movie.class));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            for (Movie movie : movieList) {
                System.out.print("Title: "
                        + movie.getOriginalTitle()
                        + "; poster of 780 size: "
                        + movie.getPosterURLs().get780()
                        + "; cast: " + movie.getCast()
                        + "; streaming info: " + movie.getStreamingInfo());
                System.out.println();
                System.out.println();
            }
            page++;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        registerDataDemo("us");
    }
}
