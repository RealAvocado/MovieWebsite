package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieCountryPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieCountryPairRepository extends JpaRepository<MovieCountryPair, Integer> {
}
