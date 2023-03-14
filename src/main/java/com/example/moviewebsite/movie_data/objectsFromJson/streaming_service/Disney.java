package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Disney {
    @JsonAlias({"ca","gb","us","nl","au","nz","at","de","it","es","ch","fr","be","dk","fi","no","pt","se","ar","br","cl","co","mx","ie","jp","id","is","ec","pa","pe","sg","my","th","kr","hk","za","tr","il"})
    private Country country;

    public Disney() {
    }

    public Disney(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Disney{" + "country=" + country + '}';
    }
}
