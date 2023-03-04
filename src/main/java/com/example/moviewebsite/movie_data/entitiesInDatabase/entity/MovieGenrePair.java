package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre_pairing")
public class MovieGenrePair {
    @Id
    @SequenceGenerator(name="genre_seq",sequenceName="genre_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genre_seq")
    private Integer auto_id;
    private String imdbID;
    private Integer genre; //code

    //Reference the primary key of basic_movie_info as the foreign key of this table, also name "imdbID".
    //"insertable = false, updatable = false" is needed to avoid conflicts between repeated named columns
    @ManyToOne
    @JoinColumn(name = "imdbID", insertable = false, updatable = false)
    private BasicMovieInfo basicMovieInfo;

    public MovieGenrePair() {
    }

    public MovieGenrePair(String imdbID, Integer genre) {
        this.imdbID = imdbID;
        this.genre = genre;
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

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" + "auto_id='" + auto_id + '\'' + ", imdbID='" + imdbID + '\'' + ", genre='" + genre + '\'' + '}';
    }
}
