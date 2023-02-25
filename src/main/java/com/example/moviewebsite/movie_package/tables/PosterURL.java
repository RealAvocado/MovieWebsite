package com.example.moviewebsite.movie_package.tables;

import javax.persistence.*;

@Entity
public class PosterURL {
    @Id
    private String imdbID;
    private String _154;
    private String _185;
    private String _342;
    private String _500;
    private String _780;
    private String _92;
    private String original;

    public PosterURL() {
    }

    public PosterURL(String imdbID, String _154, String _185, String _342, String _500, String _780, String _92, String original) {
        this.imdbID = imdbID;
        this._154 = _154;
        this._185 = _185;
        this._342 = _342;
        this._500 = _500;
        this._780 = _780;
        this._92 = _92;
        this.original = original;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String get_154() {
        return _154;
    }

    public void set_154(String _154) {
        this._154 = _154;
    }

    public String get_185() {
        return _185;
    }

    public void set_185(String _185) {
        this._185 = _185;
    }

    public String get_342() {
        return _342;
    }

    public void set_342(String _342) {
        this._342 = _342;
    }

    public String get_500() {
        return _500;
    }

    public void set_500(String _500) {
        this._500 = _500;
    }

    public String get_780() {
        return _780;
    }

    public void set_780(String _780) {
        this._780 = _780;
    }

    public String get_92() {
        return _92;
    }

    public void set_92(String _92) {
        this._92 = _92;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "PosterURL{" + "imdbID='" + imdbID + '\'' + ", _154='" + _154 + '\'' + ", _185='" + _185 + '\'' + ", _342='" + _342 + '\'' + ", _500='" + _500 + '\'' + ", _780='" + _780 + '\'' + ", _92='" + _92 + '\'' + ", original='" + original + '\'' + '}';
    }
}
