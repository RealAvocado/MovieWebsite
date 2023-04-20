package com.example.moviewebsite.user_data.dto;



public class LoginFormData {

    private String email;
    private String password;

    public LoginFormData() {
    }

    public LoginFormData(String email, String password) {
        this.email = email;
        this.password = password;
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
}
