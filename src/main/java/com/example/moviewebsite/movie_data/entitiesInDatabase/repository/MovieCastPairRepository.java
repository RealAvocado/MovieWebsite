package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCastPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCastPairRepository extends JpaRepository<MovieCastPair, Integer> {
    List<MovieCastPair> findMovieCastPairByCast(String cast);

    Optional<MovieCastPair> findMovieCountryPairByImdbID(String imdbID);
    Optional<MovieCastPair> findMovieCountryPairByCastAndImdbID(String cast, String imdbID);
}
