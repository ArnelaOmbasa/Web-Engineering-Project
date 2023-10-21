package com.example.webengineeringproject.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Recipe {
    @Id
    private String recipeId;
    private String title;
    private String description;
    private List<String> ingredients;
    private String imageURL;
    private String author;
    private List<String> comments;

    public Recipe() {
        this.recipeId = this.recipeId;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.imageURL = imageURL;
        this.comments = comments;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
