package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @SequenceGenerator(name="country_seq",sequenceName="country_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="country_seq")
    private String auto_id;
    private String imdbID;
    private String country;

    public Country() {
    }

    public Country(String imdbID, String country) {
        this.imdbID = imdbID;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" + "auto_id='" + auto_id + '\'' + ", imdbID='" + imdbID + '\'' + ", country='" + country + '\'' + '}';
    }
}
