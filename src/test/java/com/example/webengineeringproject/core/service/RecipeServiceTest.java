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

import java.util.ArrayList;
import java.util.Optional;


@AutoConfigureMockMvc
@SpringBootTest
public class RecipeServiceTest {

    @MockBean
    RecipeRepository recipeRepository;

    @Autowired
    RecipeService recipeService;

    @Test
    public void shouldReturnRecipeWhenCreated() {
        RecipeRequestDTO requestDTO = new RecipeRequestDTO("Spaghetti Bolognese", "Classic Italian dish", new ArrayList<>(), "https://example.com/spaghetti.jpg");
        Recipe savedRecipe = new Recipe();
        savedRecipe.setRecipeId("someRecipeId");
        savedRecipe.setTitle("Spaghetti Bolognese");
        savedRecipe.setDescription("Classic Italian dish");
        savedRecipe.setImageURL("https://example.com/spaghetti.jpg");

        Mockito.when(recipeRepository.save(ArgumentMatchers.any(Recipe.class))).thenReturn(savedRecipe);

        RecipeDTO result = recipeService.createRecipe(requestDTO);

        Assertions.assertEquals("Spaghetti Bolognese", result.getTitle());
        Assertions.assertEquals("Classic Italian dish", result.getDescription());
        Assertions.assertEquals("https://example.com/spaghetti.jpg", result.getImageURL());
    }

    @Test
    public void shouldReturnRecipeById() {
        Recipe mockRecipe = new Recipe();
        mockRecipe.setRecipeId("someRecipeId");
        mockRecipe.setTitle("Spaghetti Bolognese");
        mockRecipe.setDescription("Classic Italian dish");
        mockRecipe.setImageURL("https://example.com/spaghetti.jpg");

        Mockito.when(recipeRepository.findById("someRecipeId")).thenReturn(Optional.of(mockRecipe));

        RecipeDTO result = recipeService.getRecipeById("someRecipeId");

        Assertions.assertEquals("someRecipeId", result.getRecipeId());
        Assertions.assertEquals("Spaghetti Bolognese", result.getTitle());
    }
}
