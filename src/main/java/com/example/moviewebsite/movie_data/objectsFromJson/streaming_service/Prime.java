package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Prime {
    @JsonAlias({"ie","us","hk","ru","ar","cz","in","mx","ch","ee","dk","ec","pl","pa","kr","md","lt","ua","it","sg","az","mk","hr","au","gb","rs","fr","th","ae","ro","de","jp","za","br","at","id","gr","nz","pt","cy","nl","bg","is","tr","cl","hu","my","be","se","pe","ca","ph","no","es","il","vn","co","fi"})
    private Country country;

    public Prime() {
    }

    public Prime(Country country) {
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
        return "Prime{" + "country=" + country + '}';
    }
}
