package com.example.moviewebsite.movie_data.entitiesInDatabase.repository;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;
import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.MovieGenrePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasicMovieInfoRepository extends JpaRepository<BasicMovieInfo, String>, JpaSpecificationExecutor<BasicMovieInfo> {
    //read
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbID(String imdbID);
    List<BasicMovieInfo> findBasicMovieInfoByOriginalTitle(String originalTitle);
    List<BasicMovieInfo> findBasicMovieInfoByLanguage(String language);
    @Query ("SELECT basic_movie_info FROM BasicMovieInfo basic_movie_info WHERE basic_movie_info.year >= :year and basic_movie_info.year < :year+10")
    List<BasicMovieInfo> findBasicMovieInfoByYear(@Param("year") Integer year);
    @Query ("SELECT DISTINCT basic_movie_info FROM BasicMovieInfo basic_movie_info INNER JOIN MovieGenrePair movie_genre_pair ON basic_movie_info.imdbID = movie_genre_pair.imdbID WHERE movie_genre_pair.genre =:genre")
    List<BasicMovieInfo> findBasicMovieInfoByGenre(@Param("genre") String genre);

    //query about streaming links
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndNetflixLink(String imdbID, String netflixLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndPrimeLink(String imdbID, String primeLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndDisneyLink(String imdbID, String disneyLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndParamountLink(String imdbID, String paramountLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndStarzLink(String imdbID, String starzLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndPeacockLink(String imdbID, String peacockLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndHuluLink(String imdbID, String huluLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndHboLink(String imdbID, String hboLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndAppleLink(String imdbID, String appleLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndShowtimeLink(String imdbID, String showtimeLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndMubiLink(String imdbID, String mubiLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndCuriosityLink(String imdbID, String curiosityLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndAll4Link(String imdbID, String all4Link);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndCraveLink(String imdbID, String craveLink);
    Optional<BasicMovieInfo> findBasicMovieInfoByImdbIDAndIplayerLink(String imdbID, String iplayerLink);


    //update
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update BasicMovieInfo basic_movie_info set basic_movie_info.originalTitle = :newTitle where basic_movie_info.imdbID = :id")
    int updateMovieTitle(@Param("newTitle") String newTitle, @Param("id") String id);

    //update streaming links
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.netflixLink = :netflixLink where basic_movie_info.imdbID = :id")
    int updateNetflixLink(@Param("netflixLink") String netflixLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.primeLink = :primeLink where basic_movie_info.imdbID = :id")
    int updatePrimeLink(@Param("primeLink") String primeLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.disneyLink = :disneyLink where basic_movie_info.imdbID = :id")
    int updateDisneyLink(@Param("disneyLink") String disneyLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.paramountLink = :paramountLink where basic_movie_info.imdbID = :id")
    int updateParamountLink(@Param("paramountLink") String paramountLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.starzLink = :starzLink where basic_movie_info.imdbID = :id")
    int updateStarzLink(@Param("starzLink") String starzLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.peacockLink = :peacockLink where basic_movie_info.imdbID = :id")
    int updatePeacockLink(@Param("peacockLink") String peacockLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.huluLink = :huluLink where basic_movie_info.imdbID = :id")
    int updateHuluLink(@Param("huluLink") String huluLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.hboLink = :hboLink where basic_movie_info.imdbID = :id")
    int updateHboLink(@Param("hboLink") String hboLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.appleLink = :appleLink where basic_movie_info.imdbID = :id")
    int updateAppleLink(@Param("appleLink") String appleLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.showtimeLink = :showtimeLink where basic_movie_info.imdbID = :id")
    int updateShowtimeLink(@Param("showtimeLink") String showtimeLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.mubiLink = :mubiLink where basic_movie_info.imdbID = :id")
    int updateMubiLink(@Param("mubiLink") String mubiLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.curiosityLink = :curiosityLink where basic_movie_info.imdbID = :id")
    int updateCuriosityLink(@Param("curiosityLink") String curiosityLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.all4Link = :all4Link where basic_movie_info.imdbID = :id")
    int updateAll4Link(@Param("all4Link") String all4Link, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.craveLink = :craveLink where basic_movie_info.imdbID = :id")
    int updateCraveLink(@Param("craveLink") String craveLink, @Param("id") String id);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update BasicMovieInfo basic_movie_info set basic_movie_info.iplayerLink = :iplayerLink where basic_movie_info.imdbID = :id")
    int updateIplayerLink(@Param("iplayerLink") String iplayerLink, @Param("id") String id);

    //delete
    int deleteBasicMovieInfoByImdbID(String imdbID);
}
