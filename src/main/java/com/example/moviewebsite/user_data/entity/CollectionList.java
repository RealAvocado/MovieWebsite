package com.example.moviewebsite.user_data.entity;

import com.example.moviewebsite.movie_data.entitiesInDatabase.entity.BasicMovieInfo;

import javax.persistence.*;

@Entity
@Table(name = "collection_list")
public class CollectionList {
    @Id
    @SequenceGenerator(name="watchlist_seq",sequenceName="watchlist_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="watchlist_seq")
    private int auto_id;
    private String userID;
    private String imdbID;

    @ManyToOne
    @JoinColumn(name = "userID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "imdbID", insertable = false, updatable = false)
    private BasicMovieInfo basicMovieInfo;

    public CollectionList() {
    }

    public CollectionList(int auto_id, String userID, String imdbID) {
        this.auto_id = auto_id;
        this.userID = userID;
        this.imdbID = imdbID;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
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
