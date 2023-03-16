package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCountryPairRepository extends JpaRepository<MovieCountryPair, Integer> {
    List<MovieCountryPair> findMovieCountryPairByCountry(String country);

    Optional<MovieCountryPair> findMovieCountryPairByImdbID(String imdbID);
    Optional<MovieCountryPair> findMovieCountryPairByCountryAndImdbID(String country, String imdbID);
}
