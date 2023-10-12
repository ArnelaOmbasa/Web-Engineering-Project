package com.example.webengineeringproject.core.model;

import java.util.List;

public class User {

    private int userId;

    private String username;

    private String password;

    private String email;


    private Role role;

    private List<Integer> recipes;

    private List<Integer> comments;

    public enum Role {
        USER,
        ADMIN
    }

    public User(int userId, String username, String password, String email, Role role, List<Integer> recipes, List<Integer> comments) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.recipes = recipes;
        this.comments = comments;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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

