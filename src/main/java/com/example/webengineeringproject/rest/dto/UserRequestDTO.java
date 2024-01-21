package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.model.enums.UserRole;

public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
    private UserRole role;


    public UserRequestDTO() { }

    public UserRequestDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
/*
    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        return user;
    }*/
public User toEntity() {
    User user = new User();
    user.setUsername(username);
    // Remove the direct password setting
    user.setEmail(email);
    user.setRole(role);
    return user;
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




}
