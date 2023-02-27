package com.example.moviewebsite.movie_package.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class BasicMovieInfo {
    @Id
    @Column(name = "imdbID")
    private String imdbID;
    private String originalTitle;
    private String language;
    private int year;
    private String overview;
    private int imdbRating;


    public BasicMovieInfo() {
    }

    public BasicMovieInfo(String imdbID, String originalTitle, String language, int year, String overview, int imdbRating) {
        this.imdbID = imdbID;
        this.originalTitle = originalTitle;
        this.language = language;
        this.year = year;
        this.overview = overview;
        this.imdbRating = imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "BasicMovieInfo{" + "imdbID='" + imdbID + '\'' + ", originalTitle='" + originalTitle + '\'' + ", language='" + language + '\'' + ", year=" + year + ", overview='" + overview + '\'' + ", imdbRating=" + imdbRating + '}';
    }
}
