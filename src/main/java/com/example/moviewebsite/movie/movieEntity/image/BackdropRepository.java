package com.example.moviewebsite.movie.movieEntity.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackdropRepository extends JpaRepository<BackdropURLs, String> {

}