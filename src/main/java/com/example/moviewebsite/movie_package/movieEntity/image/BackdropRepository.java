package com.example.moviewebsite.movie_package.movieEntity.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackdropRepository extends JpaRepository<BackdropURLs, String> {

}