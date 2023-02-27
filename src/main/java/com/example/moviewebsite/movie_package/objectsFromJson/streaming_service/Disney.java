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
public class Disney {
    @JsonProperty("us")
    private Us us;
    @JsonProperty("gb")
    private Gb gb;


    /**
     * No args constructor for use in serialization
     *
     */
    public Disney() {
    }

    /**
     *
     * @param us
     */
    public Disney(Us us) {
        super();
        this.us = us;
    }

    public Disney(Gb gb) {
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

    public Disney withUs(Us us) {
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

    public Disney withGb(Gb gb) {
        this.gb = gb;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Disney.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("us");
        sb.append('=');
        sb.append(((this.us == null)?"<null>":this.us));
        sb.append(',');
        sb.append("gb");
        sb.append('=');
        sb.append(((this.gb == null)?"<null>":this.gb));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
