package com.example.moviewebsite.movie_data.objectsFromJson.image;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "154",
        "185",
        "342",
        "500",
        "780",
        "92",
        "original"
})
@Generated("jsonschema2pojo")
public class PosterURLs {

    @JsonProperty("154")
    private String _154;
    @JsonProperty("185")
    private String _185;
    @JsonProperty("342")
    private String _342;
    @JsonProperty("500")
    private String _500;
    @JsonProperty("780")
    private String _780;
    @JsonProperty("92")
    private String _92;
    @JsonProperty("original")
    private String original;

    /**
     * No args constructor for use in serialization
     *
     */
    public PosterURLs() {
    }

    /**
     *
     * @param original
     * @param _185
     * @param _342
     * @param _92
     * @param _154
     * @param _780
     * @param _500
     */
    public PosterURLs(String _154, String _185, String _342, String _500, String _780, String _92, String original) {
        super();
        this._154 = _154;
        this._185 = _185;
        this._342 = _342;
        this._500 = _500;
        this._780 = _780;
        this._92 = _92;
        this.original = original;
    }

    @JsonProperty("154")
    public String get154() {
        return _154;
    }

    @JsonProperty("154")
    public void set154(String _154) {
        this._154 = _154;
    }

    public PosterURLs with154(String _154) {
        this._154 = _154;
        return this;
    }

    @JsonProperty("185")
    public String get185() {
        return _185;
    }

    @JsonProperty("185")
    public void set185(String _185) {
        this._185 = _185;
    }

    public PosterURLs with185(String _185) {
        this._185 = _185;
        return this;
    }

    @JsonProperty("342")
    public String get342() {
        return _342;
    }

    @JsonProperty("342")
    public void set342(String _342) {
        this._342 = _342;
    }

    public PosterURLs with342(String _342) {
        this._342 = _342;
        return this;
    }

    @JsonProperty("500")
    public String get500() {
        return _500;
    }

    @JsonProperty("500")
    public void set500(String _500) {
        this._500 = _500;
    }

    public PosterURLs with500(String _500) {
        this._500 = _500;
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

    public PosterURLs with780(String _780) {
        this._780 = _780;
        return this;
    }

    @JsonProperty("92")
    public String get92() {
        return _92;
    }

    @JsonProperty("92")
    public void set92(String _92) {
        this._92 = _92;
    }

    public PosterURLs with92(String _92) {
        this._92 = _92;
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

    public PosterURLs withOriginal(String original) {
        this.original = original;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(PosterURLs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append('[');
        sb.append("_154");
        sb.append('=');
        sb.append(((this._154 == null)?"<null>":this._154));
        sb.append(',');
        sb.append("_185");
        sb.append('=');
        sb.append(((this._185 == null)?"<null>":this._185));
        sb.append(',');
        sb.append("_342");
        sb.append('=');
        sb.append(((this._342 == null)?"<null>":this._342));
        sb.append(',');
        sb.append("_500");
        sb.append('=');
        sb.append(((this._500 == null)?"<null>":this._500));
        sb.append(',');
        sb.append("_780");
        sb.append('=');
        sb.append(((this._780 == null)?"<null>":this._780));
        sb.append(',');
        sb.append("_92");
        sb.append('=');
        sb.append(((this._92 == null)?"<null>":this._92));
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