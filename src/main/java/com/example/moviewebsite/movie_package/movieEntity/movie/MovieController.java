package com.example.moviewebsite.movie_package.movieEntity.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

//    @PostMapping
//    public void registerNewMovie(@RequestBody Movie movie){
//        movieService.addNewMovie(movie);
//    }
    @PostMapping
    public void registerGroupMovie() throws IOException, InterruptedException {
        movieService.addGroupMovie();
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
