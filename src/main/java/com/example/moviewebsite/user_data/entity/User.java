package com.example.moviewebsite.user_data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String userID;
    private String name;
    private String gender;
    private String email;
    private String password;

    public User() {
    }

    public User(String userID, String name, String gender, String email, String password) {
        this.userID = userID;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "User{" + "userID='" + userID + '\'' + ", name='" + name + '\'' + ", gender='" + gender + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}
