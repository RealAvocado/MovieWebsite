package com.example.moviewebsite.movie;

import com.example.moviewebsite.movie.movieEntity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
