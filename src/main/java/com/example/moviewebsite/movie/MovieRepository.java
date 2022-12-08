package com.example.moviewebsite.movie;

import com.example.moviewebsite.movie.movieEntity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    //    @Query("SELECT m FROM Movie m WHERE m.name = ?1 AND m.year = ?2")
//    Optional<Movie> findMovieByNameAndYear(String name, Integer year);
    Optional<Movie> findMovieByImdbID(String imdbId);

}
