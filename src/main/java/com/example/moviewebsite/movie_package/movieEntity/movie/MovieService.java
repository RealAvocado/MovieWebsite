package com.example.moviewebsite.movie_package.movieEntity.movie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByImdbID(movie.getImdbID());
        if (movieOptional.isPresent()){
            throw new IllegalStateException("Movie already exists");
        }
        movieRepository.save(movie);
    }

    public void addGroupMovie() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://streaming-availability.p.rapidapi.com/search/pro?country=gb&service=netflix&type=movie&order_by=original_title&year_min=1960&year_max=2022&genre=18&page=1&desc=true&language=en&output_language=en")).header("X-RapidAPI-Key", "f96592562cmsh3f7abed7974f7c2p1235dbjsnc0c2ce7a1ead").header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com").method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //split a large sets of json into an array
        String json = response.body().substring(11, response.body().length() - 18);
        List<Movie> movieList = new ArrayList<>();
        JSONArray arr = JSON.parseArray(json);

        for (int i = 0; i < arr.size(); i++) {
            ObjectMapper mapper = new ObjectMapper();
            Movie movie = mapper.readValue(arr.getString(i), Movie.class);
            movieList.add(movie);
        }
        movieRepository.saveAll(movieList);
    }

    public void deleteMovie(String movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists){
            throw new IllegalStateException("movie with id " + movieId + " does not exists");
        }
        movieRepository.deleteById(movieId);
    }



//    @Transactional
//    public void updateMovie(Long movieId,
//                            String youTubeLink,
//                            String imDbLink) {
//        Movie movie = movieRepository.findById(movieId).
//                orElseThrow(()->new IllegalStateException(
//                "movie with id " + movieId + " does not exist"));
//
//        if (youTubeLink != null && youTubeLink.length() > 0 && !Objects.equals(movie.getYouTubeLink(),youTubeLink)){
//            movie.setYouTubeLink(youTubeLink);
//        }
//
//        if (imDbLink != null && imDbLink.length() > 0 && !Objects.equals(movie.getIMDbLink(),imDbLink)){
//            movie.setIMDbLink(imDbLink);
//        }
//    }
}
