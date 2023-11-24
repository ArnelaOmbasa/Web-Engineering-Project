package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void shouldReturnAllRecipes() {

        List<Recipe> recipes = recipeRepository.findAll();

        Assertions.assertFalse(recipes.isEmpty());
    }

    @Test
    public void shouldFindRecipeByTitle() {

        Optional<Recipe> recipe = recipeRepository.findByTitle("Spaghetti Bolognese");

        Assertions.assertTrue(recipe.isPresent());
        Assertions.assertEquals("Spaghetti Bolognese", recipe.get().getTitle());
    }

    @Test
    public void shouldNotFindNonexistentRecipeById() {
        Optional<Recipe> foundRecipe = recipeRepository.findById("NonexistentId");

        Assertions.assertFalse(foundRecipe.isPresent());
    }


}