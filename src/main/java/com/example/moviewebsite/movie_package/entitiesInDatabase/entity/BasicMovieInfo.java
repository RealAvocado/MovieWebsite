package com.example.moviewebsite.movie_package.entitiesInDatabase.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "basic_movie_info")
@SecondaryTables({
        @SecondaryTable(name = "backdrop_secondary", pkJoinColumns = @PrimaryKeyJoinColumn(name = "imdbID")),
        @SecondaryTable(name = "poster_secondary", pkJoinColumns = @PrimaryKeyJoinColumn(name = "imdbID")),
        @SecondaryTable(name = "streaming_link_secondary", pkJoinColumns = @PrimaryKeyJoinColumn(name = "imdbID"))

})
public class BasicMovieInfo {
    @Id
    @Column(name = "imdbID")
    private String imdbID;
    private String originalTitle;
    private String language;
    private int year;
    private String overview;
    private int imdbRating;

    @Column(table = "backdrop_secondary")
    private String backdrop_1280;
    @Column(table = "backdrop_secondary")
    private String backdrop_300;
    @Column(table = "backdrop_secondary")
    private String backdrop_780;
    @Column(table = "backdrop_secondary")
    private String backdrop_original;

    @Column(table = "poster_secondary")
    private String poster_154;
    @Column(table = "poster_secondary")
    private String poster_185;
    @Column(table = "poster_secondary")
    private String poster_342;
    @Column(table = "poster_secondary")
    private String poster_500;
    @Column(table = "poster_secondary")
    private String poster_780;
    @Column(table = "poster_secondary")
    private String poster_92;
    @Column(table = "poster_secondary")
    private String poster_original;

    @Column(table = "streaming_link_secondary")
    private String netflixLink;
    @Column(table = "streaming_link_secondary")
    private String primeLink;
    @Column(table = "streaming_link_secondary")
    private String disneyLink;
    @Column(table = "streaming_link_secondary")
    private String paramountLink;
    @Column(table = "streaming_link_secondary")
    private String starzLink;

    public BasicMovieInfo() {
    }

    public BasicMovieInfo(String imdbID, String originalTitle, String language, @Nullable int year, @Nullable String overview, @Nullable int imdbRating,
                          @Nullable String backdrop_1280, @Nullable String backdrop_300, @Nullable String backdrop_780, @Nullable String backdrop_original,
                          @Nullable String poster_154, @Nullable String poster_185, @Nullable String poster_342, @Nullable String poster_500, @Nullable String poster_780, @Nullable String poster_92, @Nullable String poster_original,
                          @Nullable String netflixLink, @Nullable String primeLink, @Nullable String disneyLink, @Nullable String paramountLink, @Nullable String starzLink)
    {
        this.imdbID = imdbID;
        this.originalTitle = originalTitle;
        this.language = language;
        this.year = year;
        this.overview = overview;
        this.imdbRating = imdbRating;
        this.backdrop_1280 = backdrop_1280;
        this.backdrop_300 = backdrop_300;
        this.backdrop_780 = backdrop_780;
        this.backdrop_original = backdrop_original;
        this.poster_154 = poster_154;
        this.poster_185 = poster_185;
        this.poster_342 = poster_342;
        this.poster_500 = poster_500;
        this.poster_780 = poster_780;
        this.poster_92 = poster_92;
        this.poster_original = poster_original;
        this.netflixLink = netflixLink;
        this.primeLink = primeLink;
        this.disneyLink = disneyLink;
        this.paramountLink = paramountLink;
        this.starzLink = starzLink;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getBackdrop_1280() {
        return backdrop_1280;
    }

    public void setBackdrop_1280(String backdrop_1280) {
        this.backdrop_1280 = backdrop_1280;
    }

    public String getBackdrop_300() {
        return backdrop_300;
    }

    public void setBackdrop_300(String backdrop_300) {
        this.backdrop_300 = backdrop_300;
    }

    public String getBackdrop_780() {
        return backdrop_780;
    }

    public void setBackdrop_780(String backdrop_780) {
        this.backdrop_780 = backdrop_780;
    }

    public String getBackdrop_original() {
        return backdrop_original;
    }

    public void setBackdrop_original(String backdrop_original) {
        this.backdrop_original = backdrop_original;
    }

    public String getPoster_154() {
        return poster_154;
    }

    public void setPoster_154(String poster_154) {
        this.poster_154 = poster_154;
    }

    public String getPoster_185() {
        return poster_185;
    }

    public void setPoster_185(String poster_185) {
        this.poster_185 = poster_185;
    }

    public String getPoster_342() {
        return poster_342;
    }

    public void setPoster_342(String poster_342) {
        this.poster_342 = poster_342;
    }

    public String getPoster_500() {
        return poster_500;
    }

    public void setPoster_500(String poster_500) {
        this.poster_500 = poster_500;
    }

    public String getPoster_780() {
        return poster_780;
    }

    public void setPoster_780(String poster_780) {
        this.poster_780 = poster_780;
    }

    public String getPoster_92() {
        return poster_92;
    }

    public void setPoster_92(String poster_92) {
        this.poster_92 = poster_92;
    }

    public String getPoster_original() {
        return poster_original;
    }

    public void setPoster_original(String poster_original) {
        this.poster_original = poster_original;
    }

    public String getNetflixLink() {
        return netflixLink;
    }

    public void setNetflixLink(String netflixLink) {
        this.netflixLink = netflixLink;
    }

    public String getPrimeLink() {
        return primeLink;
    }

    public void setPrimeLink(String primeLink) {
        this.primeLink = primeLink;
    }

    public String getDisneyLink() {
        return disneyLink;
    }

    public void setDisneyLink(String disneyLink) {
        this.disneyLink = disneyLink;
    }

    public String getParamountLink() {
        return paramountLink;
    }

    public void setParamountLink(String paramountLink) {
        this.paramountLink = paramountLink;
    }

    public String getStarzLink() {
        return starzLink;
    }

    public void setStarzLink(String starzLink) {
        this.starzLink = starzLink;
    }

    @Override
    public String toString() {
        return "BasicMovieInfo{" + "imdbID='" +
                imdbID + '\'' + ", originalTitle='" +
                originalTitle + '\'' + ", language='" +
                language + '\'' + ", year=" +
                year + ", overview='" +
                overview + '\'' + ", imdbRating=" +
                imdbRating + ", backdrop_1280='" +
                backdrop_1280 + '\'' + ", backdrop_300='" +
                backdrop_300 + '\'' + ", backdrop_780='" +
                backdrop_780 + '\'' + ", backdrop_original='" +
                backdrop_original + '\'' + ", poster_154='" +
                poster_154 + '\'' + ", poster_185='" +
                poster_185 + '\'' + ", poster_342='" +
                poster_342 + '\'' + ", poster_500='" +
                poster_500 + '\'' + ", poster_780='" +
                poster_780 + '\'' + ", poster_92='" +
                poster_92 + '\'' + ", poster_original='" +
                poster_original + '\'' + ", netflixLink='" +
                netflixLink + '\'' + ", primeLink='" +
                primeLink + '\'' + ", disneyLink='" +
                disneyLink + '\'' + ", paramountLink='" +
                paramountLink + '\'' + ", starzLink='" +
                starzLink + '\'' + '}';
    }
}
