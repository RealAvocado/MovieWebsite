package com.example.moviewebsite.test.movieEntity.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "link",
        "added",
        "leaving"
})
@Generated("jsonschema2pojo")
public class Gb {
    @JsonProperty("link")
    private String link;
    @JsonProperty("added")
    private long added;
    @JsonProperty("leaving")
    private long leaving;

    /**
     * No args constructor for use in serialization
     *
     */
    public Gb() {
    }

    /**
     *
     * @param added
     * @param link
     * @param leaving
     */
    public Gb(String link, long added, long leaving) {
        super();
        this.link = link;
        this.added = added;
        this.leaving = leaving;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public Gb withLink(String link) {
        this.link = link;
        return this;
    }

    @JsonProperty("added")
    public long getAdded() {
        return added;
    }

    @JsonProperty("added")
    public void setAdded(long added) {
        this.added = added;
    }

    public Gb withAdded(long added) {
        this.added = added;
        return this;
    }

    @JsonProperty("leaving")
    public long getLeaving() {
        return leaving;
    }

    @JsonProperty("leaving")
    public void setLeaving(long leaving) {
        this.leaving = leaving;
    }

    public Gb withLeaving(long leaving) {
        this.leaving = leaving;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Us.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("added");
        sb.append('=');
        sb.append(this.added);
        sb.append(',');
        sb.append("leaving");
        sb.append('=');
        sb.append(this.leaving);
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
