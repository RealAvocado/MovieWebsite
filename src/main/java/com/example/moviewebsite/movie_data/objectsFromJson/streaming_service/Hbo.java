package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Generated("jsonschema2pojo")
public class Hbo {
    @JsonAlias({"nl","us","ar","br","cl","co","ec","mx","pe","dk","fi","no","es","se","bg","hr","cz","hu","md","mk","pl","pt","ro","rs"})
    private Country country;

    public Hbo() {
    }

    public Hbo(Country country) {
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
        return "Hbo{" + "country=" + country + '}';
    }
}
