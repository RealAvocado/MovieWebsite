package com.example.moviewebsite.movie_package.tables;

import javax.persistence.*;

@Entity
public class BackDropURL {
    @Id
    private String imdbID;
    private String _1280;
    private String _300;
    private String _780;
    private String original;

    public BackDropURL() {
    }

    public BackDropURL(String imdbID, String _1280, String _300, String _780, String original) {
        this.imdbID = imdbID;
        this._1280 = _1280;
        this._300 = _300;
        this._780 = _780;
        this.original = original;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String get_1280() {
        return _1280;
    }

    public void set_1280(String _1280) {
        this._1280 = _1280;
    }

    public String get_300() {
        return _300;
    }

    public void set_300(String _300) {
        this._300 = _300;
    }

    public String get_780() {
        return _780;
    }

    public void set_780(String _780) {
        this._780 = _780;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "BackDropURL{" + "imdbID='" + imdbID + '\'' + ", _1280='" + _1280 + '\'' + ", _300='" + _300 + '\'' + ", _780='" + _780 + '\'' + ", original='" + original + '\'' + '}';
    }
}
