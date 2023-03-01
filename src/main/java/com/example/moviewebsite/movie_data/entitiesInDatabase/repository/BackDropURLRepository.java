package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BackDropURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackDropURLRepository extends JpaRepository<BackDropURL, String> {
    Optional<BackDropURL> findBackDropURLByImdbID(String imdbID);
}
