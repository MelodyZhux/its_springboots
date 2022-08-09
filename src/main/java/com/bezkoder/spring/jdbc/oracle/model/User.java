package com.bezkoder.spring.jdbc.oracle.model;

public class User {

    private long id;
    private String user_name;
    private String user_password;

    public User() {

    }

    public User(long id, String user_name, String user_password) {
        this.id = id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public User(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", user_name=" + user_name + "user_password=" + user_password + "]";
    }

}
