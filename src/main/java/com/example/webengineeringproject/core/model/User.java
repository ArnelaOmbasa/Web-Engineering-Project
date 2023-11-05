package com.example.webengineeringproject.core.model;

import com.example.webengineeringproject.core.model.enums.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document

public class User {
    @Id

    private String userId;

    private String username;

    private String password;

    private String email;


    private UserRole role;

    private List<Integer> recipes;

    private List<Integer> comments;





    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Integer> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Integer> recipes) {
        this.recipes = recipes;
    }

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }

}

