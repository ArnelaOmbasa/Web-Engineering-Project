package com.example.webengineeringproject.rest.dto;

public class LoginDTO {
    private String jwt;


    public LoginDTO(String jwt) {
        this.jwt = jwt;
    }
}

