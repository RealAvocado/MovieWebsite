package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieGenrePairRepository extends JpaRepository<MovieGenrePair, Integer> {
    List<MovieGenrePair> findMovieGenrePairByGenre(int genre);

    @Modifying
    @Query(value = "insert into movie_genre_pairing (imdbID, genre) values (imdbID, genre)",nativeQuery = true)
    void insertMovieGenrePair(@Param("imdbID") String imdbID, @Param("genre") int genre);

    Optional<MovieGenrePair> findMovieGenrePairByImdbID(String imdbID);
    Optional<MovieGenrePair> findMovieGenrePairByImdbIDAndGenre(String imdbID, int genre);
}
