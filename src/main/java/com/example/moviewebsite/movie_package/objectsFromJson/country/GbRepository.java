package com.example.moviewebsite.movie_package.objectsFromJson.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GbRepository extends JpaRepository<Gb, String> {

}
