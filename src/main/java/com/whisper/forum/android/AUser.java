package com.whisper.forum.android;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class AUser {
        int id;
        String name;
        String password;
        String email;
        List<AArticle> aArticles;

    public List<AArticle> getaArticles() {
        return aArticles;
    }

    public void setaArticles(List<AArticle> aArticles) {
        this.aArticles = aArticles;
    }

    public AUser() {
    }

    public AUser(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", aArticles=" + aArticles +
                '}';
    }
}
