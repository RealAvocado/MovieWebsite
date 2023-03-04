package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_cast_pairing")
public class MovieCastPair {
    @Id
    @SequenceGenerator(name="cast_seq",sequenceName="cast_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cast_seq")
    private Integer auto_id;
    private String imdbID;
    private String cast;

    //Reference the primary key of basic_movie_info as the foreign key of this table, also name "imdbID".
    @ManyToOne
    @JoinColumn(name = "imdbID", insertable = false, updatable = false)
    private BasicMovieInfo basicMovieInfo;

    public MovieCastPair() {
    }

    public MovieCastPair(String imdbID, String cast) {
        this.imdbID = imdbID;
        this.cast = cast;
    }

    public Integer getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Integer auto_id) {
        this.auto_id = auto_id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }


    @Override
    public String toString() {
        return "Cast{" + "auto_id='" + auto_id + '\'' + ", imdbID='" + imdbID + '\'' + ", cast='" + cast + '\'' + '}';
    }
}
