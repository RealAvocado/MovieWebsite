package com.example.moviewebsite.movie_package.objectsFromJson.movie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    public void addNewMovie() throws JsonProcessingException {
        String json = "{\n" + "\"imdbID\":\"tt8721424\",\n" + "\"tmdbID\":\"537116\",\n" + "\"imdbRating\":75,\n" + "\"imdbVoteCount\":105222,\n" + "\"tmdbRating\":77,\n" + "\"backdropPath\":\"/rKe3MR2u4ZZ0y9uKivzKJRrqBCe.jpg\",\n" + "\"backdropURLs\":\n" + "{\n" + "\"1280\":\"https://image.tmdb.org/t/p/w1280/rKe3MR2u4ZZ0y9uKivzKJRrqBCe.jpg\",\n" + "\"300\":\"https://image.tmdb.org/t/p/w300/rKe3MR2u4ZZ0y9uKivzKJRrqBCe.jpg\",\n" + "\"780\":\"https://image.tmdb.org/t/p/w780/rKe3MR2u4ZZ0y9uKivzKJRrqBCe.jpg\",\n" + "\"original\":\"https://image.tmdb.org/t/p/original/rKe3MR2u4ZZ0y9uKivzKJRrqBCe.jpg\"\n" + "},\n" + "\"originalTitle\":\"tick, tick... BOOM!\",\n" + "\"genres\":[1,18,4],\"countries\":[\"US\"],\n" + "\"year\":2021,\n" + "\"runtime\":120,\n" + "\"cast\":[\"Andrew Garfield\",\"Alexandra Shipp\",\"Robin de Jesús\",\"Vanessa Hudgens\",\"Joshua Henry\",\"Jonathan Marc Sherman\",\"Michaela Jaé Rodriguez\"],\n" + "\"significants\":[\"Lin-Manuel Miranda\"],\"title\":\"tick, tick... BOOM!\",\n" + "\"overview\":\"On the cusp of his 30th birthday, Jonathon Larson, a promising young theater composer, navigates love, friendship, and the pressures of life as an artist in New York City.\",\n" + "\"tagline\":\"How much time do we have to do something great?\",\n" + "\"video\":\"YJserno8tyU\",\n" + "\"posterPath\":\"/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"posterURLs\":\n" + "{\n" + "\"154\":\"https://image.tmdb.org/t/p/w154/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"185\":\"https://image.tmdb.org/t/p/w185/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"342\":\"https://image.tmdb.org/t/p/w342/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"500\":\"https://image.tmdb.org/t/p/w500/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"780\":\"https://image.tmdb.org/t/p/w780/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"92\":\"https://image.tmdb.org/t/p/w92/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\",\n" + "\"original\":\"https://image.tmdb.org/t/p/original/DPmfcuR8fh8ROYXgdjrAjSGA0o.jpg\"\n" + "},\n" + "\"age\":12,\n" + "\"streamingInfo\":\n" + "{\n" + "\"netflix\":\n" + "{\n" + "\"us\":\n" + "{\n" + "\"link\":\"https://www.netflix.com/title/81149184/\",\n" + "\"added\":1637374344,\n" + "\"leaving\":0\n" + "}\n" + "}\n" + "},\n" + "\"originalLanguage\":\"en\"}";
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(json, Movie.class);
        Optional<Movie> movieOptional = movieRepository.findMovieByImdbID(movie.getImdbID());
        if (movieOptional.isPresent()) {
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
        if (!exists) {
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
