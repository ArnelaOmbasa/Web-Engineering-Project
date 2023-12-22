package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.repository.RecipeRepository;
import com.example.webengineeringproject.rest.dto.RecipeDTO;
import com.example.webengineeringproject.rest.dto.RecipeRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
public class RecipeServiceTest {

    @MockBean
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeService recipeService;

    @Test
    public void shouldReturnRecipeWhenCreated() {
        RecipeRequestDTO requestDTO = new RecipeRequestDTO("Spaghetti Bolognese", "Classic Italian dish", Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"), "https://example.com/spaghetti.jpg");
        String ownerId = "owner123";

        Recipe savedRecipe = new Recipe();
        savedRecipe.setRecipeId("someRecipeId");
        savedRecipe.setTitle("Spaghetti Bolognese");
        savedRecipe.setDescription("Classic Italian dish");
        savedRecipe.setIngredients(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"));
        savedRecipe.setImageURL("https://example.com/spaghetti.jpg");
        savedRecipe.setOwnerId(ownerId);

        Mockito.when(recipeRepository.save(ArgumentMatchers.any(Recipe.class))).thenReturn(savedRecipe);

        RecipeDTO result = recipeService.createRecipe(requestDTO, ownerId);

        Assertions.assertEquals("someRecipeId", result.getRecipeId());
        Assertions.assertEquals("Spaghetti Bolognese", result.getTitle());
        Assertions.assertEquals("Classic Italian dish", result.getDescription());
        Assertions.assertEquals(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"), result.getIngredients());
        Assertions.assertEquals("https://example.com/spaghetti.jpg", result.getImageURL());
        Assertions.assertEquals(ownerId, result.getOwnerId());
    }


    @Test
    public void shouldReturnRecipeById() {
        Recipe mockRecipe = new Recipe();
        mockRecipe.setRecipeId("someRecipeId");
        mockRecipe.setTitle("Spaghetti Bolognese");
        mockRecipe.setDescription("Classic Italian dish");
        mockRecipe.setIngredients(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"));
        mockRecipe.setImageURL("https://example.com/spaghetti.jpg");
        mockRecipe.setOwnerId("owner123");

        Mockito.when(recipeRepository.findById("someRecipeId")).thenReturn(Optional.of(mockRecipe));

        RecipeDTO result = recipeService.getRecipeById("someRecipeId");

        Assertions.assertEquals("someRecipeId", result.getRecipeId());
        Assertions.assertEquals("Spaghetti Bolognese", result.getTitle());
        Assertions.assertEquals("Classic Italian dish", result.getDescription());
        Assertions.assertEquals(Arrays.asList("Spaghetti", "Ground beef", "Tomato sauce"), result.getIngredients());
        Assertions.assertEquals("https://example.com/spaghetti.jpg", result.getImageURL());
        Assertions.assertEquals("owner123", result.getOwnerId());
    }
}
