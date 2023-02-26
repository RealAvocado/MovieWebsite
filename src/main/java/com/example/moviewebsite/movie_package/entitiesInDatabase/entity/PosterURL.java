package com.example.moviewebsite.movie_package.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class PosterURL {
    @Id
    private String imdbID;
    private String poster_154;
    private String poster_185;
    private String poster_342;
    private String poster_500;
    private String poster_780;
    private String poster_92;
    private String poster_original;

    public PosterURL() {
    }

    public PosterURL(String imdbID, String poster_154, String poster_185, String poster_342, String poster_500, String poster_780, String poster_92, String poster_original) {
        this.imdbID = imdbID;
        this.poster_154 = poster_154;
        this.poster_185 = poster_185;
        this.poster_342 = poster_342;
        this.poster_500 = poster_500;
        this.poster_780 = poster_780;
        this.poster_92 = poster_92;
        this.poster_original = poster_original;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster_154() {
        return poster_154;
    }

    public void setPoster_154(String poster_154) {
        this.poster_154 = poster_154;
    }

    public String getPoster_185() {
        return poster_185;
    }

    public void setPoster_185(String poster_185) {
        this.poster_185 = poster_185;
    }

    public String getPoster_342() {
        return poster_342;
    }

    public void setPoster_342(String poster_342) {
        this.poster_342 = poster_342;
    }

    public String getPoster_500() {
        return poster_500;
    }

    public void setPoster_500(String poster_500) {
        this.poster_500 = poster_500;
    }

    public String getPoster_780() {
        return poster_780;
    }

    public void setPoster_780(String poster_780) {
        this.poster_780 = poster_780;
    }

    public String getPoster_92() {
        return poster_92;
    }

    public void setPoster_92(String poster_92) {
        this.poster_92 = poster_92;
    }

    public String getPoster_original() {
        return poster_original;
    }

    public void setPoster_original(String poster_original) {
        this.poster_original = poster_original;
    }

    @Override
    public String toString() {
        return "PosterURL{" + "imdbID='" + imdbID + '\'' + ", poster_154='" + poster_154 + '\'' + ", poster_185='" + poster_185 + '\'' + ", poster_342='" + poster_342 + '\'' + ", poster_500='" + poster_500 + '\'' + ", poster_780='" + poster_780 + '\'' + ", poster_92='" + poster_92 + '\'' + ", poster_original='" + poster_original + '\'' + '}';
    }
}
