package com.example.moviewebsite.movie.movieEntity.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GbRepository extends JpaRepository<Gb, String> {

}
