package com.example.moviewebsite.movie_package.objectsFromJson.streaming_service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "netflix"
})
@Generated("jsonschema2pojo")
public class StreamingInfo {

    @JsonProperty("netflix")
    private Netflix netflix;

    @JsonProperty("prime")
    private Prime prime;

    @JsonProperty("disney")
    private Disney disney;

    @JsonProperty("peacock")
    private Peacock peacock;

    @JsonProperty("paramount")
    private Paramount paramount;

    @JsonProperty("starz")
    private Starz starz;

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

    @JsonProperty("prime")
    public Prime getPrime() {
        return prime;
    }

    @JsonProperty("prime")
    public void setPrime(Prime prime) {
        this.prime = prime;
    }

    public StreamingInfo withPrime(Prime prime) {
        this.prime = prime;
        return this;
    }

    @JsonProperty("disney")
    public Disney getDisney() {
        return disney;
    }

    @JsonProperty("disney")
    public void setDisney(Disney disney) {
        this.disney = disney;
    }

    public StreamingInfo withDisney(Disney disney) {
        this.disney = disney;
        return this;
    }

    @JsonProperty("peacock")
    public Peacock getPeacock() {
        return peacock;
    }

    @JsonProperty("peacock")
    public void setPeacock(Peacock peacock) {
        this.peacock = peacock;
    }

    public StreamingInfo withPeacock(Peacock peacock) {
        this.peacock = peacock;
        return this;
    }

    @JsonProperty("paramount")
    public Paramount getParamount() {
        return paramount;
    }

    @JsonProperty("paramount")
    public void setParamount(Paramount paramount) {
        this.paramount = paramount;
    }

    public StreamingInfo withParamount(Paramount paramount) {
        this.paramount = paramount;
        return this;
    }

    @JsonProperty("starz")
    public Starz getStarz() {
        return starz;
    }

    @JsonProperty("starz")
    public void setStarz(Starz starz) {
        this.starz = starz;
    }

    public StreamingInfo withStarz(Starz starz) {
        this.starz = starz;
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
        sb.append("prime");
        sb.append('=');
        sb.append(((this.prime == null)?"<null>":this.prime));
        sb.append(',');
        sb.append("disney");
        sb.append('=');
        sb.append(((this.disney == null)?"<null>":this.disney));
        sb.append(',');
        sb.append("peacock");
        sb.append('=');
        sb.append(((this.peacock == null)?"<null>":this.peacock));
        sb.append(',');
        sb.append("paramount");
        sb.append('=');
        sb.append(((this.paramount == null)?"<null>":this.paramount));
        sb.append(',');
        sb.append("starz");
        sb.append('=');
        sb.append(((this.starz == null)?"<null>":this.starz));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}