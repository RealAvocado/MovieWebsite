package com.example.moviewebsite.movie_data.entitiesInDatabase.controller;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.service.impl.BasicMovieInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie/basicInfo")
public class BasicMovieInfoController {
    private final BasicMovieInfoServiceImpl basicMovieInfoServiceImpl;

    @Autowired
    public BasicMovieInfoController(BasicMovieInfoServiceImpl basicMovieInfoServiceImpl) {
        this.basicMovieInfoServiceImpl = basicMovieInfoServiceImpl;
    }

    @GetMapping(path = "title={movieTitle}")
    public List<BasicMovieInfo> getMovieInfoByTitle(@PathVariable("movieTitle") String movieTitle) {
        return basicMovieInfoServiceImpl.getMovieInfoByTitle(movieTitle);
    }

    @GetMapping(path = "language={language}")
    public List<BasicMovieInfo> getMovieInfoByLanguage(@PathVariable("language") String language) {
        return basicMovieInfoServiceImpl.getMovieInfoByLanguage(language);
    }

    @GetMapping(path = "year={years}")
    public List<BasicMovieInfo> getMovieInfoByYear(@PathVariable String years) {
        return basicMovieInfoServiceImpl.getMovieInfoByYear(years);
    }

    @GetMapping(path = "genre={genres}")
    public List<BasicMovieInfo> getMovieInfoByGenre(@PathVariable Integer genres) {
        return basicMovieInfoServiceImpl.getMovieInfoByGenre(genres);
    }

    @PostMapping(path = "country={country},service={service}")
    public void registerMovieInfoByCountry(@PathVariable String country, @PathVariable String service) {
        try {
            basicMovieInfoServiceImpl.addMovieInfoByCountry(country,service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping(path = "test/single_movie")
    public void registerMovieInfoSingleJsonTest(String json){
        basicMovieInfoServiceImpl.addMovieInfoFromSingleJson("{\"imdbID\":\"tt0068646\",\"tmdbID\":\"238\",\"imdbRating\":92,\"imdbVoteCount\":1883760,\"tmdbRating\":87,\"backdropPath\":\"/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"backdropURLs\":{\"1280\":\"https://image.tmdb.org/t/p/w1280/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"300\":\"https://image.tmdb.org/t/p/w300/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"780\":\"https://image.tmdb.org/t/p/w780/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"original\":\"https://image.tmdb.org/t/p/original/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\"},\"originalTitle\":\"The Godfather\",\"genres\":[80,18],\"countries\":[\"US\"],\"year\":1972,\"runtime\":175,\"cast\":[\"Marlon Brando\",\"Al Pacino\",\"James Caan\",\"Robert Duvall\",\"Richard S. Castellano\",\"Diane Keaton\",\"Talia Shire\"],\"significants\":[\"Francis Ford Coppola\"],\"title\":\"The Godfather\",\"overview\":\"Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.\",\"tagline\":\"An offer you can't refuse.\",\"video\":\"Ew9ngL1GZvs\",\"posterPath\":\"/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"posterURLs\":{\"154\":\"https://image.tmdb.org/t/p/w154/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"185\":\"https://image.tmdb.org/t/p/w185/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"342\":\"https://image.tmdb.org/t/p/w342/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"500\":\"https://image.tmdb.org/t/p/w500/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"780\":\"https://image.tmdb.org/t/p/w780/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"92\":\"https://image.tmdb.org/t/p/w92/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"original\":\"https://image.tmdb.org/t/p/original/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\"},\"age\":16,\"streamingInfo\":{\"all4\":{\"gb\":{\"link\":\"https://www.channel4.com/programmes/the-godfather\",\"added\":1677800922,\"leaving\":1680303600}}},\"originalLanguage\":\"en\"}");
        basicMovieInfoServiceImpl.addMovieInfoFromSingleJson("{\"imdbID\":\"tt0068646\",\"tmdbID\":\"238\",\"imdbRating\":92,\"imdbVoteCount\":1883760,\"tmdbRating\":87,\"backdropPath\":\"/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"backdropURLs\":{\"1280\":\"https://image.tmdb.org/t/p/w1280/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"300\":\"https://image.tmdb.org/t/p/w300/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"780\":\"https://image.tmdb.org/t/p/w780/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\",\"original\":\"https://image.tmdb.org/t/p/original/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\"},\"originalTitle\":\"The Godfather\",\"genres\":[80,18],\"countries\":[\"US\"],\"year\":1972,\"runtime\":175,\"cast\":[\"Marlon Brando\",\"Al Pacino\",\"James Caan\",\"Robert Duvall\",\"Richard S. Castellano\",\"Diane Keaton\",\"Talia Shire\"],\"significants\":[\"Francis Ford Coppola\"],\"title\":\"The Godfather\",\"overview\":\"Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.\",\"tagline\":\"An offer you can't refuse.\",\"video\":\"Ew9ngL1GZvs\",\"posterPath\":\"/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"posterURLs\":{\"154\":\"https://image.tmdb.org/t/p/w154/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"185\":\"https://image.tmdb.org/t/p/w185/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"342\":\"https://image.tmdb.org/t/p/w342/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"500\":\"https://image.tmdb.org/t/p/w500/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"780\":\"https://image.tmdb.org/t/p/w780/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"92\":\"https://image.tmdb.org/t/p/w92/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\",\"original\":\"https://image.tmdb.org/t/p/original/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\"},\"age\":16,\"streamingInfo\":{\"peacock\":{\"us\":{\"link\":\"https://www.peacocktv.com/watch/asset/movies/drama/the-godfather/d1ed5b6e-2160-399c-99b8-caf5a7702dde\",\"added\":1672632807,\"leaving\":1680343140}}},\"originalLanguage\":\"en\"}");
    }

    @PostMapping(path = "all")
    public void registerAllMovieInfo() {
        try {
            basicMovieInfoServiceImpl.addAllMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "{imdbID}")
    public void deleteMovieInfo(@PathVariable String imdbID) {
        basicMovieInfoServiceImpl.deleteMovieInfo(imdbID);
    }

    @PutMapping(path = "{newTitle},{imdbID}")
    public void updateMovieName(@PathVariable String newTitle, @PathVariable String imdbID) {
        basicMovieInfoServiceImpl.updateMovieName(newTitle, imdbID);
    }
}
