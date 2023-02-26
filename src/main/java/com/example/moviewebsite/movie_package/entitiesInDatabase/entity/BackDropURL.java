package com.example.moviewebsite.movie_package.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class BackDropURL {
    @Id
    private String imdbID;
    private String backdrop_1280;
    private String backdrop_300;
    private String backdrop_780;
    private String backdrop_original;

    public BackDropURL() {
    }

    public BackDropURL(String imdbID, String backdrop_1280, String backdrop_300, String backdrop_780, String backdrop_original) {
        this.imdbID = imdbID;
        this.backdrop_1280 = backdrop_1280;
        this.backdrop_300 = backdrop_300;
        this.backdrop_780 = backdrop_780;
        this.backdrop_original = backdrop_original;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getBackdrop_1280() {
        return backdrop_1280;
    }

    public void setBackdrop_1280(String backdrop_1280) {
        this.backdrop_1280 = backdrop_1280;
    }

    public String getBackdrop_300() {
        return backdrop_300;
    }

    public void setBackdrop_300(String backdrop_300) {
        this.backdrop_300 = backdrop_300;
    }

    public String getBackdrop_780() {
        return backdrop_780;
    }

    public void setBackdrop_780(String backdrop_780) {
        this.backdrop_780 = backdrop_780;
    }

    public String getBackdrop_original() {
        return backdrop_original;
    }

    public void setBackdrop_original(String backdrop_original) {
        this.backdrop_original = backdrop_original;
    }

    @Override
    public String toString() {
        return "BackDropURL{" + "imdbID='" + imdbID + '\'' + ", backdrop_1280='" + backdrop_1280 + '\'' + ", backdrop_300='" + backdrop_300 + '\'' + ", backdrop_780='" + backdrop_780 + '\'' + ", backdrop_original='" + backdrop_original + '\'' + '}';
    }
}
