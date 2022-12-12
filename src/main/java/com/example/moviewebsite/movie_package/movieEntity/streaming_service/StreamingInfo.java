package com.example.moviewebsite.movie_package.movieEntity.streaming_service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "netflix"
})
@Generated("jsonschema2pojo")
public class StreamingInfo implements Serializable {

    @JsonProperty("netflix")
    private Netflix netflix;

    /**
     * No args constructor for use in serialization
     *
     */
    public StreamingInfo() {
    }

    /**
     *
     * @param netflix
     */
    public StreamingInfo(Netflix netflix) {
        super();
        this.netflix = netflix;
    }

    @JsonProperty("netflix")
    public Netflix getNetflix() {
        return netflix;
    }

    @JsonProperty("netflix")
    public void setNetflix(Netflix netflix) {
        this.netflix = netflix;
    }

    public StreamingInfo withNetflix(Netflix netflix) {
        this.netflix = netflix;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StreamingInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("netflix");
        sb.append('=');
        sb.append(((this.netflix == null)?"<null>":this.netflix));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}