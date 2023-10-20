package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Recipe;

import java.util.List;

public class RecipeRequestDTO {
    private String title;
    private String description;
    private List<String> ingredients;
    private String imageURL;

    public RecipeRequestDTO(String title, String description, List<String> ingredients, String imageURL) {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.imageURL = imageURL;
    }
    public Recipe toEntity() {
        Recipe recipe = new Recipe();
        recipe.setTitle(this.title);
        recipe.setDescription(this.description);
        recipe.setIngredients(this.ingredients);
        recipe.setImageURL(this.imageURL);

        return recipe;
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
}
