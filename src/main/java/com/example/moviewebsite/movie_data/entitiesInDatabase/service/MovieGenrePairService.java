package com.example.moviewebsite.movie_data.entitiesInDatabase.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.MovieGenrePairRepository;
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
public class MovieGenrePairService {
    private final MovieGenrePairRepository movieGenrePairRepository;

    @Autowired
    public MovieGenrePairService(MovieGenrePairRepository movieGenrePairRepository) {
        this.movieGenrePairRepository = movieGenrePairRepository;
    }

    public List<MovieGenrePair> getMoviesByGenre(int genre) {
        return movieGenrePairRepository.findMovieGenrePairByGenre(genre);
    }

    public void addMovieGenrePairs(String country) throws IOException, InterruptedException {
        int page = 1;
        int totalPages = 1;
        for (int i = 0; i < totalPages; i++) {
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=" + country +
                    "&services=netflix%2Cprime%2Cdisney%2Cstarz&type=movie&order_by=imdb_vote_count&page=" + page +
                    "&desc=true&language=en&output_language=en";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                    .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //get total pages amount and set loop counts
            if (i == 0){
                int lastColonIndex = response.body().lastIndexOf(':');
                totalPages = Integer.parseInt(response.body().substring(lastColonIndex + 1, response.body().length()-1));
            }

            //split a large sets of json into an array
            int lastCommaIndex = response.body().lastIndexOf(',');
            String json = response.body().substring(11, lastCommaIndex);
            JSONArray arr = JSON.parseArray(json);

            //database operation
            for (int j = 0; j < arr.size(); j++) {
                ObjectMapper mapper = new ObjectMapper();
                try{
                    Movie movie = mapper.readValue(arr.getString(j), Movie.class);
                    for (Integer genre:movie.getGenres()) {
                        MovieGenrePair movieGenrePair = new MovieGenrePair(movie.getImdbID(),genre);
                        Optional<MovieGenrePair> movieGenrePairOptional = movieGenrePairRepository.findMovieGenrePairByImdbIDAndGenre(movie.getImdbID(),genre);
                        if (movieGenrePairOptional.isEmpty()){
                            movieGenrePairRepository.save(movieGenrePair);
                            //movieGenrePairRepository.insertMovieGenrePair(movie.getImdbID(),genre);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            page++;
        }
    }
}
