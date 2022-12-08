package com.example.moviewebsite.movie;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.test.movieEntity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DataRequest {
    //private static Session movieRepository;
    private final MovieRepository movieRepository;

    //@Autowired

    public DataRequest(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        MovieRepository movieRepository = new MovieRepository() {
//            @Override
//            public Optional<com.example.moviewebsite.movie.movieEntity.Movie> findMovieByImdbID(String imdbId) {
//                return Optional.empty();
//            }
//
//            @Override
//            public List<com.example.moviewebsite.movie.movieEntity.Movie> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<com.example.moviewebsite.movie.movieEntity.Movie> findAll(Sort sort) {
//                return null;
//            }
//
//            @Override
//            public List<com.example.moviewebsite.movie.movieEntity.Movie> findAllById(Iterable<String> strings) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> List<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> List<S> saveAllAndFlush(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void deleteAllInBatch(Iterable<com.example.moviewebsite.movie.movieEntity.Movie> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(Iterable<String> strings) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public com.example.moviewebsite.movie.movieEntity.Movie getOne(String s) {
//                return null;
//            }
//
//            @Override
//            public com.example.moviewebsite.movie.movieEntity.Movie getById(String s) {
//                return null;
//            }
//
//            @Override
//            public com.example.moviewebsite.movie.movieEntity.Movie getReferenceById(String s) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> List<S> findAll(Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> List<S> findAll(Example<S> example, Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<com.example.moviewebsite.movie.movieEntity.Movie> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<com.example.moviewebsite.movie.movieEntity.Movie> findById(String s) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(String s) {
//                return false;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(String s) {
//
//            }
//
//            @Override
//            public void delete(com.example.moviewebsite.movie.movieEntity.Movie entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends String> strings) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends com.example.moviewebsite.movie.movieEntity.Movie> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie> boolean exists(Example<S> example) {
//                return false;
//            }
//
//            @Override
//            public <S extends com.example.moviewebsite.movie.movieEntity.Movie, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//                return null;
//            }
//        };
        //DataRequest dataRequest = new DataRequest(movieRepository);
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
