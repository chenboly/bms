package com.example.bms.models;

import java.sql.Timestamp;

public class User {
    private Integer id;
    private String username;
    private String fullname;
    private String email;
    private String gender;
    private boolean status;
    private Timestamp createdAt;

    public User() {
    }

    public User(Integer id, String username, String fullname, String email, String gender, boolean status, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", fullname='" + fullname + '\'' + ", email='" + email + '\'' + ", gender='" + gender + '\'' + ", status=" + status + ", createdAt=" + createdAt + '}';
    }
}
