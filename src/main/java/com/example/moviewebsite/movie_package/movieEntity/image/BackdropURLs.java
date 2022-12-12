package com.example.moviewebsite.movie_package.movieEntity.image;

import com.example.moviewebsite.movie_package.movieEntity.movie.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "1280",
        "300",
        "780",
        "original"
})
@Generated("jsonschema2pojo")
@Entity
@Table(name="backdrop_url")
public class BackdropURLs implements Serializable {

    @JsonProperty("1280")
    private String _1280;
    @JsonProperty("300")
    private String _300;
    @JsonProperty("780")
    private String _780;
    @JsonProperty("original")
    @Id
    private String original;

    @OneToOne
    @JoinColumn(name="imdbID")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public BackdropURLs() {
    }

    /**
     *
     * @param original
     * @param _1280
     * @param _780
     * @param _300
     */
    public BackdropURLs(String _1280, String _300, String _780, String original) {
        super();
        this._1280 = _1280;
        this._300 = _300;
        this._780 = _780;
        this.original = original;
    }

    @JsonProperty("1280")
    public String get1280() {
        return _1280;
    }

    @JsonProperty("1280")
    public void set1280(String _1280) {
        this._1280 = _1280;
    }

    public BackdropURLs with1280(String _1280) {
        this._1280 = _1280;
        return this;
    }

    @JsonProperty("300")
    public String get300() {
        return _300;
    }

    @JsonProperty("300")
    public void set300(String _300) {
        this._300 = _300;
    }

    public BackdropURLs with300(String _300) {
        this._300 = _300;
        return this;
    }

    @JsonProperty("780")
    public String get780() {
        return _780;
    }

    @JsonProperty("780")
    public void set780(String _780) {
        this._780 = _780;
    }

    public BackdropURLs with780(String _780) {
        this._780 = _780;
        return this;
    }

    @JsonProperty("original")
    public String getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    public BackdropURLs withOriginal(String original) {
        this.original = original;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BackdropURLs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_1280");
        sb.append('=');
        sb.append(((this._1280 == null)?"<null>":this._1280));
        sb.append(',');
        sb.append("_300");
        sb.append('=');
        sb.append(((this._300 == null)?"<null>":this._300));
        sb.append(',');
        sb.append("_780");
        sb.append('=');
        sb.append(((this._780 == null)?"<null>":this._780));
        sb.append(',');
        sb.append("original");
        sb.append('=');
        sb.append(((this.original == null)?"<null>":this.original));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}