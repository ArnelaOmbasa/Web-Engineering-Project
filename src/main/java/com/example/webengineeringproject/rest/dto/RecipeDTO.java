package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Recipe;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeDTO {
    private String recipeId;
    private String title;
    private String description;
    private List<String> ingredients;
    private String imageURL;

    private List<String> comments;


    public RecipeDTO(Recipe recipe) {
        this.recipeId=recipe.getRecipeId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.ingredients = recipe.getIngredients();
        this.imageURL = recipe.getImageURL();
        this.comments = recipe.getComments();

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
