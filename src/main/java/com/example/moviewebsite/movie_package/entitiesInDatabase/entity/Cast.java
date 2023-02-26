package com.example.moviewebsite.movie_package.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class Cast {
    @Id
    @SequenceGenerator(name="cast_seq",sequenceName="cast_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cast_seq")
    private String auto_id;
    private String imdbID;
    private String cast;

    public Cast() {
    }

    public Cast(String imdbID, String cast) {
        this.imdbID = imdbID;
        this.cast = cast;
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
