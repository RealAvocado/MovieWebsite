package com.example.moviewebsite.movie_package.entitiesInDatabase.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_package.entitiesInDatabase.repository.BasicMovieInfoRepository;
import com.example.moviewebsite.movie_package.objectsFromJson.movie.Movie;
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

    public void addMovieInfo(String totalPages, String country) throws IOException, InterruptedException {
        int page = 0;
        for (int p = 0; p < Integer.parseInt(totalPages); p++) {
            page++;
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=" + country + "&services=netflix%2Cprime%2Cdisney%2Cstarz&type=movie&order_by=imdb_vote_count&page=" + page + "&desc=true&language=en&output_language=en";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                    .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //split a large sets of json into an array
            String json = response.body().substring(11, response.body().length() - 19);
            //List<Movie> movieList = new ArrayList<>();
            JSONArray arr = JSON.parseArray(json);

            for (int i = 0; i < arr.size(); i++) {
                ObjectMapper mapper = new ObjectMapper();
                try{
                    Movie movie = mapper.readValue(arr.getString(i), Movie.class);
                    BasicMovieInfo basicMovieInfo = new BasicMovieInfo(
                            movie.getImdbID(), movie.getOriginalTitle(), movie.getOriginalLanguage(), movie.getYear(), movie.getOverview(), movie.getImdbRating(),
                            movie.getBackdropURLs().get1280(), movie.getBackdropURLs().get300(), movie.getBackdropURLs().get780(), movie.getBackdropURLs().getOriginal(),
                            movie.getPosterURLs().get154(), movie.getPosterURLs().get185(), movie.getPosterURLs().get342(), movie.getPosterURLs().get500(), movie.getPosterURLs().get780(), movie.getPosterURLs().get92(), movie.getPosterURLs().getOriginal(),
                            (movie.getStreamingInfo().getNetflix() == null)?null:movie.getStreamingInfo().getNetflix().getUs().getLink(),
                            (movie.getStreamingInfo().getPrime() == null)?null:movie.getStreamingInfo().getPrime().getUs().getLink(),
                            (movie.getStreamingInfo().getDisney() == null)?null:movie.getStreamingInfo().getDisney().getUs().getLink(),
                            (movie.getStreamingInfo().getParamount() == null)?null:movie.getStreamingInfo().getParamount().getUs().getLink(),
                            (movie.getStreamingInfo().getStarz() == null)?null:movie.getStreamingInfo().getStarz().getUs().getLink()
                            );
                    Optional<BasicMovieInfo> basicMovieInfoOptional = basicMovieInfoRepository.findBasicMovieInfoByImdbID(basicMovieInfo.getImdbID());
                    if (basicMovieInfoOptional.isEmpty()){
                        basicMovieInfoRepository.save(basicMovieInfo);
                    }
                    //movieList.add(movie);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

//            for (Movie movie : movieList) {
//                System.out.print("Title: "
//                        + movie.getOriginalTitle()
//                        + "; poster of 780 size: "
//                        + movie.getPosterURLs().get780()
//                        + "; cast: " + movie.getCast()
//                        + "; streaming info: " + movie.getStreamingInfo());
//                System.out.println();
//                System.out.println();
//            }
        }
    }

}
