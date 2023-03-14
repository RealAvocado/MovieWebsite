package com.example.moviewebsite.movie_data.objectsFromJson.country;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "link",
        "added",
        "leaving"
})
@Generated("jsonschema2pojo")
public class Country {
    @JsonProperty("link")
    private String link;
    @JsonProperty("added")
    private long added;
    @JsonProperty("leaving")
    private long leaving;

    public Country() {
    }

    public Country(String link, long added, long leaving) {
        this.link = link;
        this.added = added;
        this.leaving = leaving;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getLeaving() {
        return leaving;
    }

    public void setLeaving(long leaving) {
        this.leaving = leaving;
    }

    @Override
    public String toString() {
        return "Country{" + "link='" + link + '\'' + ", added=" + added + ", leaving=" + leaving + '}';
    }
}
