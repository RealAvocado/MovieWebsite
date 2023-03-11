package com.example.moviewebsite.movie_data.objectsFromJson.movie;

import com.example.moviewebsite.movie_data.objectsFromJson.image.BackdropURLs;
import com.example.moviewebsite.movie_data.objectsFromJson.image.PosterURLs;
import com.example.moviewebsite.movie_data.objectsFromJson.streaming_service.StreamingInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"imdbID", "tmdbID", "imdbRating", "imdbVoteCount", "tmdbRating", "backdropPath", "backdropURLs", "originalTitle", "genres", "countries", "year", "runtime", "cast", "significants", "title", "overview", "tagline", "video", "posterPath", "posterURLs", "age", "streamingInfo", "originalLanguage"})
@Generated("jsonschema2pojo")

public class Movie {

    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("tmdbID")
    private String tmdbID;
    @JsonProperty("imdbRating")
    private int imdbRating;
    @JsonProperty("imdbVoteCount")
    private int imdbVoteCount;
    @JsonProperty("tmdbRating")
    private int tmdbRating;
    @JsonProperty("backdropPath")
    private String backdropPath;
    @JsonProperty("backdropURLs")
    private BackdropURLs backdropURLs;
    @JsonProperty("originalTitle")
    private String originalTitle;
    @JsonProperty("genres")
    private List<Integer> genres = null;
    @JsonProperty("countries")
    private List<String> countries = null;
    @JsonProperty("year")
    private int year;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("cast")
    private List<String> cast = null;
    @JsonProperty("significants")
    private List<String> significants = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("video")
    private String video;
    @JsonProperty("posterPath")
    private String posterPath;
    @JsonProperty("posterURLs")
    private PosterURLs posterURLs;
    @JsonProperty("age")
    private int age;
    @JsonProperty("streamingInfo")
    private StreamingInfo streamingInfo;
    @JsonProperty("originalLanguage")
    private String originalLanguage;

    /**
     * No args constructor for use in serialization
     */
    public Movie() {
    }

    /**
     * @param overview
     * @param year
     * @param imdbID
     * @param imdbVoteCount
     * @param tmdbRating
     * @param runtime
     * @param imdbRating
     * @param countries
     * @param video
     * @param title
     * @param originalLanguage
     * @param cast
     * @param tmdbID
     * @param significants
     * @param originalTitle
     * @param genres
     * @param backdropURLs
     * @param tagline
     * @param backdropPath
     * @param streamingInfo
     * @param posterURLs
     * @param age
     * @param posterPath
     */
    public Movie(String imdbID, String tmdbID, int imdbRating, int imdbVoteCount, int tmdbRating, String backdropPath, BackdropURLs backdropURLs, String originalTitle, List<Integer> genres, List<String> countries, int year, int runtime, List<String> cast, List<String> significants, String title, String overview, String tagline, String video, String posterPath, PosterURLs posterURLs, int age, StreamingInfo streamingInfo, String originalLanguage) {
        super();
        this.imdbID = imdbID;
        this.tmdbID = tmdbID;
        this.imdbRating = imdbRating;
        this.imdbVoteCount = imdbVoteCount;
        this.tmdbRating = tmdbRating;
        this.backdropPath = backdropPath;
        this.backdropURLs = backdropURLs;
        this.originalTitle = originalTitle;
        this.genres = genres;
        this.countries = countries;
        this.year = year;
        this.runtime = runtime;
        this.cast = cast;
        this.significants = significants;
        this.title = title;
        this.overview = overview;
        this.tagline = tagline;
        this.video = video;
        this.posterPath = posterPath;
        this.posterURLs = posterURLs;
        this.age = age;
        this.streamingInfo = streamingInfo;
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("imdbID")
    public String getImdbID() {
        return imdbID;
    }

    @JsonProperty("imdbID")
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public Movie withImdbID(String imdbID) {
        this.imdbID = imdbID;
        return this;
    }

    @JsonProperty("tmdbID")
    public String getTmdbID() {
        return tmdbID;
    }

    @JsonProperty("tmdbID")
    public void setTmdbID(String tmdbID) {
        this.tmdbID = tmdbID;
    }

    public Movie withTmdbID(String tmdbID) {
        this.tmdbID = tmdbID;
        return this;
    }

    @JsonProperty("imdbRating")
    public int getImdbRating() {
        return imdbRating;
    }

    @JsonProperty("imdbRating")
    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Movie withImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
        return this;
    }

    @JsonProperty("imdbVoteCount")
    public int getImdbVoteCount() {
        return imdbVoteCount;
    }

    @JsonProperty("imdbVoteCount")
    public void setImdbVoteCount(int imdbVoteCount) {
        this.imdbVoteCount = imdbVoteCount;
    }

    public Movie withImdbVoteCount(int imdbVoteCount) {
        this.imdbVoteCount = imdbVoteCount;
        return this;
    }

    @JsonProperty("tmdbRating")
    public int getTmdbRating() {
        return tmdbRating;
    }

    @JsonProperty("tmdbRating")
    public void setTmdbRating(int tmdbRating) {
        this.tmdbRating = tmdbRating;
    }

    public Movie withTmdbRating(int tmdbRating) {
        this.tmdbRating = tmdbRating;
        return this;
    }

    @JsonProperty("backdropPath")
    public String getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdropPath")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Movie withBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    @JsonProperty("backdropURLs")
    public BackdropURLs getBackdropURLs() {
        return backdropURLs;
    }

    @JsonProperty("backdropURLs")
    public void setBackdropURLs(BackdropURLs backdropURLs) {
        this.backdropURLs = backdropURLs;
    }

    public Movie withBackdropURLs(BackdropURLs backdropURLs) {
        this.backdropURLs = backdropURLs;
        return this;
    }

    @JsonProperty("originalTitle")
    public String getOriginalTitle() {
        return originalTitle;
    }

    @JsonProperty("originalTitle")
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Movie withOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    @JsonProperty("genres")
    public List<Integer> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public Movie withGenres(List<Integer> genres) {
        this.genres = genres;
        return this;
    }

    @JsonProperty("countries")
    public List<String> getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public Movie withCountries(List<String> countries) {
        this.countries = countries;
        return this;
    }

    @JsonProperty("year")
    public int getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(int year) {
        this.year = year;
    }

    public Movie withYear(int year) {
        this.year = year;
        return this;
    }

    @JsonProperty("runtime")
    public int getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Movie withRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }

    @JsonProperty("cast")
    public List<String> getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Movie withCast(List<String> cast) {
        this.cast = cast;
        return this;
    }

    @JsonProperty("significants")
    public List<String> getSignificants() {
        return significants;
    }

    @JsonProperty("significants")
    public void setSignificants(List<String> significants) {
        this.significants = significants;
    }

    public Movie withSignificants(List<String> significants) {
        this.significants = significants;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Movie withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Movie withOverview(String overview) {
        this.overview = overview;
        return this;
    }

    @JsonProperty("tagline")
    public String getTagline() {
        return tagline;
    }

    @JsonProperty("tagline")
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Movie withTagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    @JsonProperty("video")
    public String getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(String video) {
        this.video = video;
    }

    public Movie withVideo(String video) {
        this.video = video;
        return this;
    }

    @JsonProperty("posterPath")
    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("posterPath")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Movie withPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    @JsonProperty("posterURLs")
    public PosterURLs getPosterURLs() {
        return posterURLs;
    }

    @JsonProperty("posterURLs")
    public void setPosterURLs(PosterURLs posterURLs) {
        this.posterURLs = posterURLs;
    }

    public Movie withPosterURLs(PosterURLs posterURLs) {
        this.posterURLs = posterURLs;
        return this;
    }

    @JsonProperty("age")
    public int getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(int age) {
        this.age = age;
    }

    public Movie withAge(int age) {
        this.age = age;
        return this;
    }

    @JsonProperty("streamingInfo")
    public StreamingInfo getStreamingInfo() {
        return streamingInfo;
    }

    @JsonProperty("streamingInfo")
    public void setStreamingInfo(StreamingInfo streamingInfo) {
        this.streamingInfo = streamingInfo;
    }

    public Movie withStreamingInfo(StreamingInfo streamingInfo) {
        this.streamingInfo = streamingInfo;
        return this;
    }

    @JsonProperty("originalLanguage")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("originalLanguage")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Movie withOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(Movie.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append('[');
        sb.append("imdbID");
        sb.append('=');
        sb.append(((this.imdbID == null) ? "<null>" : this.imdbID));
        sb.append(',');
        sb.append("tmdbID");
        sb.append('=');
        sb.append(((this.tmdbID == null) ? "<null>" : this.tmdbID));
        sb.append(',');
        sb.append("imdbRating");
        sb.append('=');
        sb.append(this.imdbRating);
        sb.append(',');
        sb.append("imdbVoteCount");
        sb.append('=');
        sb.append(this.imdbVoteCount);
        sb.append(',');
        sb.append("tmdbRating");
        sb.append('=');
        sb.append(this.tmdbRating);
        sb.append(',');
        sb.append("backdropPath");
        sb.append('=');
        sb.append(((this.backdropPath == null) ? "<null>" : this.backdropPath));
        sb.append(',');
        sb.append("backdropURLs");
        sb.append('=');
        sb.append(((this.backdropURLs == null) ? "<null>" : this.backdropURLs));
        sb.append(',');
        sb.append("originalTitle");
        sb.append('=');
        sb.append(((this.originalTitle == null) ? "<null>" : this.originalTitle));
        sb.append(',');
        sb.append("genres");
        sb.append('=');
        sb.append(((this.genres == null) ? "<null>" : this.genres));
        sb.append(',');
        sb.append("countries");
        sb.append('=');
        sb.append(((this.countries == null) ? "<null>" : this.countries));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(this.year);
        sb.append(',');
        sb.append("runtime");
        sb.append('=');
        sb.append(this.runtime);
        sb.append(',');
        sb.append("cast");
        sb.append('=');
        sb.append(((this.cast == null) ? "<null>" : this.cast));
        sb.append(',');
        sb.append("significants");
        sb.append('=');
        sb.append(((this.significants == null) ? "<null>" : this.significants));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("overview");
        sb.append('=');
        sb.append(((this.overview == null) ? "<null>" : this.overview));
        sb.append(',');
        sb.append("tagline");
        sb.append('=');
        sb.append(((this.tagline == null) ? "<null>" : this.tagline));
        sb.append(',');
        sb.append("video");
        sb.append('=');
        sb.append(((this.video == null) ? "<null>" : this.video));
        sb.append(',');
        sb.append("posterPath");
        sb.append('=');
        sb.append(((this.posterPath == null) ? "<null>" : this.posterPath));
        sb.append(',');
        sb.append("posterURLs");
        sb.append('=');
        sb.append(((this.posterURLs == null) ? "<null>" : this.posterURLs));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(this.age);
        sb.append(',');
        sb.append("streamingInfo");
        sb.append('=');
        sb.append(((this.streamingInfo == null) ? "<null>" : this.streamingInfo));
        sb.append(',');
        sb.append("originalLanguage");
        sb.append('=');
        sb.append(((this.originalLanguage == null) ? "<null>" : this.originalLanguage));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
