package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasicMovieInfoRepository extends JpaRepository<BasicMovieInfo, String> {
    List<BasicMovieInfo> findBasicMovieInfoByOriginalTitle(String originalTitle);
    List<BasicMovieInfo> findBasicMovieInfoByLanguage(String language);

    void deleteBasicMovieInfoByImdbID(String imdbID);

    Optional<BasicMovieInfo> findBasicMovieInfoByImdbID(String imdbID);
}
