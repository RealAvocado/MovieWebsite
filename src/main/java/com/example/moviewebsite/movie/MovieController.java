package com.example.moviewebsite.movie;

import com.example.moviewebsite.movie.movieEntity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovie() {
        return movieService.getMovie();
    }

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path="{movieId}")
    public void deleteMovie(@PathVariable("movieId") String movieId){
        movieService.deleteMovie(movieId);
    }

//    @PutMapping(path="{movieId}")
//    public void updateMovie(@PathVariable("movieId") Long movieId,
//                            @RequestParam(required = false) String YouTubeLink,
//                            @RequestParam(required = false) String IMDbLink){
//        movieService.updateMovie(movieId,YouTubeLink,IMDbLink);
//    }
}
