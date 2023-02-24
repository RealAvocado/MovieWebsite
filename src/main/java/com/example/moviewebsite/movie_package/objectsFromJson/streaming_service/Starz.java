package com.example.moviewebsite.movie_package.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_package.objectsFromJson.country.Gb;
import com.example.moviewebsite.movie_package.objectsFromJson.country.Us;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "us",
        "gb"
})
@Generated("jsonschema2pojo")
public class Starz {
    @JsonProperty("us")
    private Us us;
    @JsonProperty("gb")
    private Gb gb;

    /**
     * No args constructor for use in serialization
     *
     */
    public Starz() {
    }

    /**
     *
     * @param us
     */
    public Starz(Us us) {
        super();
        this.us = us;
    }

    public Starz(Gb gb) {
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

    public Starz withUs(Us us) {
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

    public Starz withGb(Gb gb) {
        this.gb = gb;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Starz.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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