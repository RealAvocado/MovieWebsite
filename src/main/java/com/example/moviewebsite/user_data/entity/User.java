package com.example.moviewebsite.user_data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String userID;
    private String userName;
    private String gender;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "basicMovieInfo")
    private List<CollectionList> collectionList = new ArrayList<>();

    public User() {
    }

    public User(String userID, String userName, String gender, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userID='" + userID + '\'' + ", userName='" + userName + '\'' + ", gender='" + gender + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}
