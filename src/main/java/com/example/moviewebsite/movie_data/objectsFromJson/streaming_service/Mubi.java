package com.example.moviewebsite.movie_data.objectsFromJson.streaming_service;

import com.example.moviewebsite.movie_data.objectsFromJson.country.Country;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Mubi {
    @JsonAlias({"ch","il","ru","be","es","at","mk","pl","md","ua","rs","se","jp","ee","ca","cy","ro","bg","dk","fi","nl","fr","az","gb","no","gr","de","hk","us","it","ae","sg","ie","vn","pa","za","cl","au","nz","tr","ar","th","in","br","ph","mx","hr","ec","co","hu","id","kr","lt","my","pe"})
    private Country country;

    public Mubi() {
    }

    public Mubi(Country country) {
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
        return "Mubi{" + "country=" + country + '}';
    }
}
