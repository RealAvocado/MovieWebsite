package com.example.moviewebsite.movie_data.entitiesInDatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_country_pairing")
public class MovieCountryPair {
    @Id
    @SequenceGenerator(name="country_seq",sequenceName="country_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="country_seq")
    private Integer auto_id;
    private String imdbID;
    private String country;

    //Reference the primary key of basic_movie_info as the foreign key of this table, also name "imdbID".
    @ManyToOne
    @JoinColumn(name = "imdbID", insertable = false, updatable = false)
    private BasicMovieInfo basicMovieInfo;

    public MovieCountryPair() {
    }

    public MovieCountryPair(String imdbID, String country) {
        this.imdbID = imdbID;
        this.country = country;
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
