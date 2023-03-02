package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class MovieGenrePair {
    @Id
    @SequenceGenerator(name="genre_seq",sequenceName="genre_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genre_seq")
    private int auto_id;
    private String imdbID;
    private int genre; //code

    public MovieGenrePair() {
    }

    public MovieGenrePair(String imdbID, int genre) {
        this.imdbID = imdbID;
        this.genre = genre;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" + "auto_id='" + auto_id + '\'' + ", imdbID='" + imdbID + '\'' + ", genre='" + genre + '\'' + '}';
    }
}
