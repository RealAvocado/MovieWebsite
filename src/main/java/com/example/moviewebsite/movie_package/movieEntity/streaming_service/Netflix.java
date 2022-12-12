package com.example.moviewebsite.movie_package.movieEntity.streaming_service;

import com.example.moviewebsite.movie_package.movieEntity.country.Gb;
import com.example.moviewebsite.movie_package.movieEntity.country.Us;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "us"
})
@Generated("jsonschema2pojo")
public class Netflix implements Serializable {

    @JsonProperty("us")
    private Us us;
    private Gb gb;


    /**
     * No args constructor for use in serialization
     *
     */
    public Netflix() {
    }

    /**
     *
     * @param us
     */
    public Netflix(Us us) {
        super();
        this.us = us;
    }

    public Netflix(Gb gb) {
        this.gb = gb;
    }

    @JsonProperty("us")
    public Us getUs() {
        return us;
    }

    @JsonProperty("us")
    public void setUs(Us us) {
        this.us = us;
    }

    public Netflix withUs(Us us) {
        this.us = us;
        return this;
    }

    @JsonProperty("gb")
    public Gb getGb() {
        return gb;
    }

    @JsonProperty("gb")
    public void setGb(Gb gb) {
        this.gb = gb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Netflix.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("us");
        sb.append('=');
        sb.append(((this.us == null)?"<null>":this.us));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}