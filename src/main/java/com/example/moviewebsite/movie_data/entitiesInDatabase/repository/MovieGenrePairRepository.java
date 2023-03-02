package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieGenrePairRepository extends JpaRepository<MovieGenrePair, String> {
    List<MovieGenrePair> findMovieGenrePairByGenre(int genre);

    Optional<MovieGenrePair> findMovieGenrePairByImdbIDAndGenre(String imdbID, int genre);
}
