package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.model.enums.UserRole;

public class UserDTO {
    private String userId;
    private String username;
    private String email;
    private UserRole role;


    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();


    }
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
}
