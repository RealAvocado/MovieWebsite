package com.example.moviewebsite.user_data.entity;

import javax.persistence.*;

@Entity
public class CollectionList {
    @Id
    @SequenceGenerator(name="watchlist_seq",sequenceName="watchlist_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="watchlist_seq")
    private String auto_id;
    private String userID;
    private String imdbID;

    public CollectionList() {
    }

    public CollectionList(String auto_id, String userID, String imdbID) {
        this.auto_id = auto_id;
        this.userID = userID;
        this.imdbID = imdbID;
    }

    public String getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(String auto_id) {
        this.auto_id = auto_id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "UserWatchList{" + "auto_id='" + auto_id + '\'' + ", userID='" + userID + '\'' + ", imdbID='" + imdbID + '\'' + '}';
    }
}
