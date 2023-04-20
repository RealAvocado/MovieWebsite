package com.example.moviewebsite.movie_data.dto;

import java.util.List;

public class SearchParam {

    private List<Integer> genres;

    private List<Integer> year;

    private String language;

    private String service;

    private String country;
    private String cast;

    private Integer page;
    private Integer size;

    public SearchParam() {
    }

    public SearchParam(List<Integer> genres, List<Integer> year, String language, String service, String country,
                       String cast, Integer page, Integer size) {
        this.genres = genres;
        this.year = year;
        this.language = language;
        this.service = service;
        this.country = country;
        this.cast = cast;
        this.page = page;
        this.size = size;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
