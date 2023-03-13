package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasicMovieInfoRepository extends JpaRepository<BasicMovieInfo, String> {
    //create
//    @Transactional
//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query(value = "insert into MovieGenrePair movie_genre_pairing ")
//    void insertGenre();

    //read
    List<BasicMovieInfo> findBasicMovieInfoByOriginalTitle(String originalTitle);
    List<BasicMovieInfo> findBasicMovieInfoByLanguage(String language);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbID(String imdbID);

    //update
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update BasicMovieInfo basic_movie_info set basic_movie_info.originalTitle = :newTitle where basic_movie_info.imdbID = :id")
    void updateMovieTitle(@Param("newTitle") String newTitle, @Param("id") String id);

    //delete
    int deleteBasicMovieInfoByImdbID(String imdbID);

}
