package com.example.webengineeringproject.rest.controller;
import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.service.RecipeService;
import com.example.webengineeringproject.rest.controllers.RecipeController;
import com.example.webengineeringproject.rest.dto.RecipeDTO;
import com.example.webengineeringproject.rest.dto.RecipeRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createRecipe_ValidRecipeRequest_ReturnsCreatedRecipe() {
        RecipeRequestDTO requestDTO = new RecipeRequestDTO("Title", "Description", Arrays.asList("Ingredient1", "Ingredient2"), "image.jpg");
        RecipeDTO createdRecipe = new RecipeDTO(new Recipe());
        when(recipeService.createRecipe(any())).thenReturn(createdRecipe);

        ResponseEntity<RecipeDTO> response = recipeController.createRecipe(requestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdRecipe, response.getBody());
    }

    @Test
    void getAllRecipes_ReturnsListOfRecipes() {
        List<RecipeDTO> recipeList = Arrays.asList(new RecipeDTO(new Recipe()), new RecipeDTO(new Recipe()));
        when(recipeService.getAllRecipes()).thenReturn(recipeList);

        ResponseEntity<List<RecipeDTO>> response = recipeController.getAllRecipes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(recipeList, response.getBody());
    }
}