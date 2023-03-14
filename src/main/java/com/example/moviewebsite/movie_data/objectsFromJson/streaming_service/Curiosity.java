package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Curiosity {
    @JsonAlias({"gb","de","dk","be","es","ch","cz","ee","ro","rs","it","no","ie","pt","pl","hr","at","ru","us","tr","ua","gr","bg","fi","mk","th","nl","cy","ca","fr","il","is","hk","vn","jp","az","mx","in","nz","ae","za","br","se","au","ph","cl","pa","ar","sg","ec","co","hu","id","kr","lt","my","pe"})
    private Country country;

    public Curiosity() {
    }

    public Curiosity(Country country) {
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
        return "Curiosity{" + "country=" + country + '}';
    }
}
