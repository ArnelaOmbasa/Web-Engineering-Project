package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository

public class RecipeRepository {
    private List<Recipe> recipes;

    public RecipeRepository() {
        this.recipes = Arrays.asList(
                new Recipe("Pasta", "Delicious pasta", Arrays.asList("Pasta", "Tomato Sauce"), "Boil pasta, add sauce", 1),
                new Recipe("Pizza", "Cheesy pizza", Arrays.asList("Dough", "Cheese", "Tomato Sauce"), "Bake the pizza", 2)
        );
        int recipeId = 1;
        for (Recipe recipe : recipes) {
            recipe.setRecipeId(recipeId++);
        }
    }

    public List<Recipe> findAll() {
        return recipes;
    }

    public Optional<Recipe> findById(int id) {
        return recipes.stream()
                .filter(recipe -> recipe.getRecipeId() == id)
                .findFirst();
    }
}
