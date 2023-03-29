package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

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

    @JsonProperty("hulu")
    private Hulu hulu;

    @JsonProperty("hbo")
    private Hbo hbo;

    @JsonProperty("apple")
    private Apple apple;

    @JsonProperty("showtime")
    private Showtime showtime;

    @JsonProperty("mubi")
    private Mubi mubi;

    @JsonProperty("curiosity")
    private Curiosity curiosity;

    @JsonProperty("all4")
    private All4 all4;

    @JsonProperty("crave")
    private Crave crave;

    @JsonProperty("iplayer")
    private Iplayer iplayer;

    /**
     * No args constructor for use in serialization
     *
     */
    public StreamingInfo() {
    }

    public StreamingInfo(Netflix netflix, Prime prime, Disney disney, Peacock peacock, Paramount paramount, Starz starz, Hulu hulu, Hbo hbo, Apple apple, Showtime showtime, Mubi mubi, Curiosity curiosity, All4 all4, Crave crave, Iplayer iplayer) {
        this.netflix = netflix;
        this.prime = prime;
        this.disney = disney;
        this.peacock = peacock;
        this.paramount = paramount;
        this.starz = starz;
        this.hulu = hulu;
        this.hbo = hbo;
        this.apple = apple;
        this.showtime = showtime;
        this.mubi = mubi;
        this.curiosity = curiosity;
        this.all4 = all4;
        this.crave = crave;
        this.iplayer = iplayer;
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

    @JsonProperty("hulu")
    public Hulu getHulu() {
        return hulu;
    }

    @JsonProperty("hulu")
    public void setHulu(Hulu hulu) {
        this.hulu = hulu;
    }

    public StreamingInfo withHulu(Hulu hulu) {
        this.hulu = hulu;
        return this;
    }

    @JsonProperty("hbo")
    public Hbo getHbo() {
        return hbo;
    }

    @JsonProperty("hbo")
    public void setHbo(Hbo hbo) {
        this.hbo = hbo;
    }

    public StreamingInfo withHbo(Hbo hbo) {
        this.hbo = hbo;
        return this;
    }

    @JsonProperty("apple")
    public Apple getApple() {
        return apple;
    }

    @JsonProperty("apple")
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public StreamingInfo withApple(Apple apple) {
        this.apple = apple;
        return this;
    }

    @JsonProperty("showtime")
    public Showtime getShowtime() {
        return showtime;
    }

    @JsonProperty("showtime")
    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public StreamingInfo withShowtime(Showtime showtime) {
        this.showtime = showtime;
        return this;
    }

    @JsonProperty("mubi")
    public Mubi getMubi() {
        return mubi;
    }

    @JsonProperty("mubi")
    public void setMubi(Mubi mubi) {
        this.mubi = mubi;
    }

    public StreamingInfo withMubi(Mubi mubi) {
        this.mubi = mubi;
        return this;
    }

    @JsonProperty("curiosity")
    public Curiosity getCuriosity() {
        return curiosity;
    }

    @JsonProperty("curiosity")
    public void setCuriosity(Curiosity curiosity) {
        this.curiosity = curiosity;
    }

    public StreamingInfo withCuriosity(Curiosity curiosity) {
        this.curiosity = curiosity;
        return this;
    }

    public All4 getAll4() {
        return all4;
    }

    public void setAll4(All4 all4) {
        this.all4 = all4;
    }

    public Crave getCrave() {
        return crave;
    }

    public void setCrave(Crave crave) {
        this.crave = crave;
    }

    public Iplayer getIplayer() {
        return iplayer;
    }

    public void setIplayer(Iplayer iplayer) {
        this.iplayer = iplayer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(StreamingInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append('[');
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
        sb.append("hulu");
        sb.append('=');
        sb.append(((this.hulu == null)?"<null>":this.hulu));
        sb.append(',');
        sb.append("hbo");
        sb.append('=');
        sb.append(((this.hbo == null)?"<null>":this.hbo));
        sb.append(',');
        sb.append("apple");
        sb.append('=');
        sb.append(((this.apple == null)?"<null>":this.apple));
        sb.append(',');
        sb.append("showtime");
        sb.append('=');
        sb.append(((this.showtime == null)?"<null>":this.showtime));
        sb.append(',');
        sb.append("mubi");
        sb.append('=');
        sb.append(((this.mubi == null)?"<null>":this.mubi));
        sb.append(',');
        sb.append("curiosity");
        sb.append('=');
        sb.append(((this.curiosity == null)?"<null>":this.curiosity));
        sb.append(',');
        sb.append("all4");
        sb.append('=');
        sb.append(((this.all4 == null)?"<null>":this.all4));
        sb.append(',');
        sb.append("crave");
        sb.append('=');
        sb.append(((this.crave == null)?"<null>":this.crave));
        sb.append(',');
        sb.append("iPlayer");
        sb.append('=');
        sb.append(((this.iplayer == null)?"<null>":this.iplayer));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}