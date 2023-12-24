package com.example.webengineeringproject.core.model;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class RecipeTest {


    @Test
    void shouldCreateNewRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipeId("1");
        recipe.setTitle("Spaghetti Bolognese");
        recipe.setDescription("Classic Italian pasta dish");
        recipe.setIngredients(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"));
        recipe.setImageURL("https://example.com/spaghetti.jpg");
        recipe.setOwnerId("owner123");

        Assertions.assertEquals("1", recipe.getRecipeId());
        Assertions.assertEquals("Spaghetti Bolognese", recipe.getTitle());
        Assertions.assertEquals("Classic Italian pasta dish", recipe.getDescription());
        Assertions.assertEquals(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"), recipe.getIngredients());
        Assertions.assertEquals("https://example.com/spaghetti.jpg", recipe.getImageURL());
        Assertions.assertEquals("owner123", recipe.getOwnerId());
    }


    @Test
    void shouldCompareTwoRecipes() {
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeId("1");
        recipe1.setTitle("Spaghetti Bolognese");
        recipe1.setDescription("Classic Italian pasta dish");
        recipe1.setIngredients(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"));
        recipe1.setImageURL("https://example.com/spaghetti.jpg");
        recipe1.setOwnerId("owner123");

        Recipe recipe2 = new Recipe();
        recipe2.setRecipeId("1");
        recipe2.setTitle("Spaghetti Bolognese");
        recipe2.setDescription("Classic Italian pasta dish");
        recipe2.setIngredients(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"));
        recipe2.setImageURL("https://example.com/spaghetti.jpg");
        recipe2.setOwnerId("owner123");

        AssertionsForInterfaceTypes
                .assertThat(recipe1)
                .usingRecursiveComparison()
                .isEqualTo(recipe2);
    }


    @Test
    void shouldAddCommentToRecipe() {
        // Arrange
        Recipe recipe = new Recipe();
        recipe.setRecipeId("1");
        recipe.setTitle("Spaghetti Bolognese");


        recipe.addComment("Delicious recipe!");


        Assertions.assertEquals(1, recipe.getComments().size());
        Assertions.assertEquals("Delicious recipe!", recipe.getComments().get(0));
    }
    @Test
    void shouldRemoveCommentFromRecipe() {
        // Arrange
        Recipe recipe = new Recipe();
        recipe.setRecipeId("1");
        recipe.setTitle("Spaghetti Bolognese");
        recipe.addComment("Delicious recipe!");

        // Act
        recipe.removeComment("Delicious recipe!");

        // Assert
        Assertions.assertEquals(0, recipe.getComments().size());
    }




}
