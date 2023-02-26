package com.example.moviewebsite.movie_package.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_package.entitiesInDatabase.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
