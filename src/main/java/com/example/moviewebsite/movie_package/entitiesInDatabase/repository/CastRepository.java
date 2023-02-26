package com.example.moviewebsite.movie_package.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CastRepository extends JpaRepository<Cast, String> {
}
