package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Apple {
    @JsonAlias({"ie","es","nl","gb","pl","ch","dk","se","no","it","md","in","cz","gr","ua","ca","pt","mx","ru","bg","cy","fi","be","ae","at","ee","th","de","az","fr","br","vn","sg","us","jp","il","hk","za","pa","au","ph","cl","ar","nz","ec","co","hu","id","kr","lt","my","pe"})
    private Country country;

    public Apple() {
    }

    public Apple(Country country) {
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
        return "Apple{" + "country=" + country + '}';
    }
}
