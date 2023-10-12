package com.example.webengineeringproject.core.model;

import java.util.List;

public class Recipe {
    private int recipeId;
    private String title;
    private String description;
    private List<String> ingredients;
    private String steps;
    private int userId;

    public Recipe(String title, String description, List<String> ingredients, String steps, int userId) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        this.userId = userId;
    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
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

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
