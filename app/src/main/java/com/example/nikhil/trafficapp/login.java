package com.example.nikhil.trafficapp;

/**
 * Created by Nikhil on 10/11/2016.
 */

public class login {

    private String username;
    private String password;

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + "]";
    }


}
