package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class StreamingLink {
    @Id
    private String imdbID;
    private String netflixLink;
    private String primeLink;
    private String disneyLink;

    public StreamingLink() {
    }

    public StreamingLink(String imdbID, String netflixLink, String primeLink, String disneyLink) {
        this.imdbID = imdbID;
        this.netflixLink = netflixLink;
        this.primeLink = primeLink;
        this.disneyLink = disneyLink;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getNetflixLink() {
        return netflixLink;
    }

    public void setNetflixLink(String netflixLink) {
        this.netflixLink = netflixLink;
    }

    public String getPrimeLink() {
        return primeLink;
    }

    public void setPrimeLink(String primeLink) {
        this.primeLink = primeLink;
    }

    public String getDisneyLink() {
        return disneyLink;
    }

    public void setDisneyLink(String disneyLink) {
        this.disneyLink = disneyLink;
    }

    @Override
    public String toString() {
        return "StreamingLink{" + "imdbID='" + imdbID + '\'' + ", netflixLink='" + netflixLink + '\'' + ", primeLink='" + primeLink + '\'' + ", disneyLink='" + disneyLink + '\'' + '}';
    }
}
