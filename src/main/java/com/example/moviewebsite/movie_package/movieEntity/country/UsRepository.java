package com.example.moviewebsite.movie_package.movieEntity.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsRepository extends JpaRepository<Us, String> {

}