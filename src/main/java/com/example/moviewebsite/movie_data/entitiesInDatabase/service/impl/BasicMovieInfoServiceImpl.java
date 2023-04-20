package com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.repository.BasicMovieInfoRepository;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.BasicMovieInfoService;
import com.example.moviewebsite.movie_data.objectsFromJson.movie.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Service
public class BasicMovieInfoServiceImpl implements BasicMovieInfoService {
    private final BasicMovieInfoRepository basicMovieInfoRepository;

    //external service
    private final MovieGenrePairServiceImpl movieGenrePairServiceImpl;
    private final MovieCountryPairServiceImpl movieCountryPairServiceImpl;
    private final MovieCastPairServiceImpl movieCastPairServiceImpl;

    @Autowired
    public BasicMovieInfoServiceImpl(BasicMovieInfoRepository basicMovieInfoRepository, MovieGenrePairServiceImpl movieGenrePairServiceImpl, MovieCountryPairServiceImpl movieCountryPairServiceImpl, MovieCastPairServiceImpl movieCastPairServiceImpl) {
        this.basicMovieInfoRepository = basicMovieInfoRepository;
        this.movieGenrePairServiceImpl = movieGenrePairServiceImpl;
        this.movieCountryPairServiceImpl = movieCountryPairServiceImpl;
        this.movieCastPairServiceImpl = movieCastPairServiceImpl;
    }

    public List<BasicMovieInfo> getMovieInfoByTitle(String movieTitle) {
        return basicMovieInfoRepository.findBasicMovieInfoByOriginalTitle(movieTitle);
    }

    public List<BasicMovieInfo> getMovieInfoByLanguage(String language) {
        return basicMovieInfoRepository.findBasicMovieInfoByLanguage(language);
    }

    public List<BasicMovieInfo> getMovieInfoByYear(String years) {
        String[] yearsArr = years.split("&");
        List<Integer> yearsListInt = new ArrayList<>();
        List<BasicMovieInfo> result = new ArrayList<>();
        for (String yearStr : yearsArr) {
            int year = Integer.parseInt(yearStr);
            yearsListInt.add(year);
        }
        Collections.sort(yearsListInt);
        for (Integer year : yearsListInt){
            result.addAll(basicMovieInfoRepository.findBasicMovieInfoByYear(year));
        }
        return result;
    }

    public List<BasicMovieInfo> getMovieInfoByGenre(Integer genres) {
        return null;
    }

    public void addMovieInfoByCountry(String country, String service) throws Exception {
        int page = 1;
        int totalPages = 5;
        for (int i = 0; i < totalPages; i++) {
            String uri = "https://streaming-availability.p.rapidapi.com/search/ultra?country=" + country + "&services=" + service + "&type=movie&order_by=imdb_rating&page=" + page + "&desc=true&output_language=en";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("X-RapidAPI-Key", "fb39dba226msh5347eb2352d5bc4p15a6e2jsnf95ec99de6bd")
                    .header("X-RapidAPI-Host", "streaming-availability.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //get total pages amount
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
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    Movie movie = mapper.readValue(arr.getString(j), Movie.class);
                    Optional<BasicMovieInfo> basicMovieInfoOptional = basicMovieInfoRepository.findBasicMovieInfoByImdbID(movie.getImdbID());
                    if (basicMovieInfoOptional.isEmpty()){
                        //save BasicMovieInfo
                        saveMovieInfo(movie);
                        //save MovieGenrePair
                        movieGenrePairServiceImpl.insertMovieGenrePairFromOneMovie(movie);
                        //save MovieCountryPair
                        movieCountryPairServiceImpl.insertMovieCountryPairFromOneMovie(movie);
                        //save MovieCastPair
                        movieCastPairServiceImpl.insertMovieCastPairFromOneMovie(movie);
                    } else {
                        updateStreamingLinks(movie);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            page++;
        }
    }

    @Transactional
    public void addMovieInfoFromSingleJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Movie movie = mapper.readValue(json, Movie.class);
            //save BasicMovieInfo
            Optional<BasicMovieInfo> basicMovieInfoOptional = basicMovieInfoRepository.findBasicMovieInfoByImdbID(movie.getImdbID());
            if (basicMovieInfoOptional.isEmpty()){
                saveMovieInfo(movie);
                //save MovieGenrePair
                movieGenrePairServiceImpl.insertMovieGenrePairFromOneMovie(movie);
                //save MovieCountryPair
                movieCountryPairServiceImpl.insertMovieCountryPairFromOneMovie(movie);
                //save MovieCastPair
                movieCastPairServiceImpl.insertMovieCastPairFromOneMovie(movie);
            } else {
                updateStreamingLinks(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAllMovies() throws Exception {
        String[] countryArr = {"ar", "au", "at", "az", "be", "br", "bg", "ca", "cl", "co", "hr", "cy", "cz", "dk", "ec", "ee", "fl", "fr", "de", "gr", "hk", "hu", "is", "in", "id", "ie", "il", "it", "jp", "lt", "my", "mx", "md", "nl", "nz", "mk", "no", "pa", "pe", "ph", "pl", "pt", "ro", "ru", "rs", "sg", "za", "kr", "es", "se", "ch", "th", "tr", "ua", "ae", "gb", "us", "vn"};
        for (String country : countryArr) {
            addMovieInfoByCountry(country,"netflix%2Cprime%2Cdisney");
        }
    }

    @Transactional
    public void saveMovieInfo(Movie movie){
        BasicMovieInfo basicMovieInfo = new BasicMovieInfo(
                movie.getImdbID(), movie.getOriginalTitle(), movie.getOriginalLanguage(), movie.getYear(), movie.getOverview(), movie.getImdbRating(),
                movie.getBackdropURLs().get1280(), movie.getBackdropURLs().get300(), movie.getBackdropURLs().get780(), movie.getBackdropURLs().getOriginal(),
                movie.getPosterURLs().get154(), movie.getPosterURLs().get185(), movie.getPosterURLs().get342(), movie.getPosterURLs().get500(), movie.getPosterURLs().get780(), movie.getPosterURLs().get92(), movie.getPosterURLs().getOriginal(),
                (movie.getStreamingInfo().getNetflix() == null)?null:movie.getStreamingInfo().getNetflix().getCountry().getLink(),
                (movie.getStreamingInfo().getPrime() == null)?null:movie.getStreamingInfo().getPrime().getCountry().getLink(),
                (movie.getStreamingInfo().getDisney() == null)?null:movie.getStreamingInfo().getDisney().getCountry().getLink(),
                (movie.getStreamingInfo().getParamount() == null)?null:movie.getStreamingInfo().getParamount().getCountry().getLink(),
                (movie.getStreamingInfo().getStarz() == null)?null:movie.getStreamingInfo().getStarz().getCountry().getLink(),
                (movie.getStreamingInfo().getPeacock() == null)?null:movie.getStreamingInfo().getPeacock().getCountry().getLink(),
                (movie.getStreamingInfo().getHulu() == null)?null:movie.getStreamingInfo().getHulu().getCountry().getLink(),
                (movie.getStreamingInfo().getHbo() == null)?null:movie.getStreamingInfo().getHbo().getCountry().getLink(),
                (movie.getStreamingInfo().getApple() == null)?null:movie.getStreamingInfo().getApple().getCountry().getLink(),
                (movie.getStreamingInfo().getShowtime() == null)?null:movie.getStreamingInfo().getShowtime().getCountry().getLink(),
                (movie.getStreamingInfo().getMubi() == null)?null:movie.getStreamingInfo().getMubi().getCountry().getLink(),
                (movie.getStreamingInfo().getCuriosity() == null)?null:movie.getStreamingInfo().getCuriosity().getCountry().getLink(),
                (movie.getStreamingInfo().getAll4() == null)?null:movie.getStreamingInfo().getAll4().getCountry().getLink(),
                (movie.getStreamingInfo().getCrave() == null)?null:movie.getStreamingInfo().getCrave().getCountry().getLink(),
                (movie.getStreamingInfo().getIplayer() == null)?null:movie.getStreamingInfo().getIplayer().getCountry().getLink()
        );
        basicMovieInfoRepository.save(basicMovieInfo);
    }

    @Transactional
    public void updateStreamingLinks(Movie movie){
        if (movie.getStreamingInfo().getNetflix() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndNetflixLink(movie.getImdbID(),movie.getStreamingInfo().getNetflix().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateNetflixLink(movie.getStreamingInfo().getNetflix().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getPrime() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndPrimeLink(movie.getImdbID(),movie.getStreamingInfo().getPrime().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updatePrimeLink(movie.getStreamingInfo().getPrime().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getDisney() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndDisneyLink(movie.getImdbID(),movie.getStreamingInfo().getDisney().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateDisneyLink(movie.getStreamingInfo().getDisney().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getParamount() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndParamountLink(movie.getImdbID(),movie.getStreamingInfo().getParamount().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateParamountLink(movie.getStreamingInfo().getParamount().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getStarz() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndStarzLink(movie.getImdbID(),movie.getStreamingInfo().getStarz().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateStarzLink(movie.getStreamingInfo().getStarz().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getPeacock() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndPeacockLink(movie.getImdbID(),movie.getStreamingInfo().getPeacock().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updatePeacockLink(movie.getStreamingInfo().getPeacock().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getHulu() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndHuluLink(movie.getImdbID(),movie.getStreamingInfo().getHulu().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateHuluLink(movie.getStreamingInfo().getHulu().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getHbo() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndHboLink(movie.getImdbID(),movie.getStreamingInfo().getHbo().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateHboLink(movie.getStreamingInfo().getHbo().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getApple() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndAppleLink(movie.getImdbID(),movie.getStreamingInfo().getApple().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateAppleLink(movie.getStreamingInfo().getApple().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getShowtime() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndShowtimeLink(movie.getImdbID(),movie.getStreamingInfo().getShowtime().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateShowtimeLink(movie.getStreamingInfo().getShowtime().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getMubi() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndMubiLink(movie.getImdbID(),movie.getStreamingInfo().getMubi().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateMubiLink(movie.getStreamingInfo().getMubi().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getCuriosity() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndCuriosityLink(movie.getImdbID(),movie.getStreamingInfo().getCuriosity().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateCuriosityLink(movie.getStreamingInfo().getCuriosity().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getAll4() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndAll4Link(movie.getImdbID(),movie.getStreamingInfo().getAll4().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateAll4Link(movie.getStreamingInfo().getAll4().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getCrave() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndCraveLink(movie.getImdbID(),movie.getStreamingInfo().getCrave().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateCraveLink(movie.getStreamingInfo().getCrave().getCountry().getLink(),movie.getImdbID());
            }
        }
        if (movie.getStreamingInfo().getIplayer() != null){
            Optional<BasicMovieInfo> optionalBasicMovieInfo = basicMovieInfoRepository.findBasicMovieInfoByImdbIDAndIplayerLink(movie.getImdbID(),movie.getStreamingInfo().getIplayer().getCountry().getLink());
            if (optionalBasicMovieInfo.isEmpty()){
                basicMovieInfoRepository.updateIplayerLink(movie.getStreamingInfo().getIplayer().getCountry().getLink(),movie.getImdbID());
            }
        }
    }

    @Transactional
    public void deleteMovieInfo(String imdbID) {
        basicMovieInfoRepository.deleteBasicMovieInfoByImdbID(imdbID);
    }

    @Transactional
    public void updateMovieName(String newTitle, String imdbID) {
        basicMovieInfoRepository.updateMovieTitle(newTitle, imdbID);
    }
}
