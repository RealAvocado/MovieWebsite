package com.example.moviewebsite.movie_package.tables;

import javax.persistence.*;

@Entity
public class Genre {
    @Id
    @SequenceGenerator(name="genre_seq",sequenceName="genre_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genre_seq")
    private String auto_id;
    private String imdbID;
    private String genre;

    public Genre() {
    }

    public Genre(String imdbID, String genre) {
        this.imdbID = imdbID;
        this.genre = genre;
    }

    public String getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(String auto_id) {
        this.auto_id = auto_id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" + "auto_id='" + auto_id + '\'' + ", imdbID='" + imdbID + '\'' + ", genre='" + genre + '\'' + '}';
    }
}
