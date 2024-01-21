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
import org.springframework.security.core.Authentication;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private Authentication authentication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(authentication.getName()).thenReturn("owner123");
    }

    @Test
    void createRecipe_ValidRecipeRequest_ReturnsCreatedRecipe() {
        RecipeRequestDTO requestDTO = new RecipeRequestDTO("Title", "Description", Arrays.asList("Ingredient1", "Ingredient2"), "image.jpg");
        RecipeDTO createdRecipe = new RecipeDTO(new Recipe());

        when(recipeService.createRecipe(any(RecipeRequestDTO.class), eq("owner123"))).thenReturn(createdRecipe);

        ResponseEntity<RecipeDTO> response = recipeController.createRecipe(requestDTO, authentication);

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

    @Test
    void getRecipeById_ValidId_ReturnsRecipe() {
        RecipeDTO expectedRecipe = new RecipeDTO(new Recipe());
        String recipeId = "testRecipeId";

        when(recipeService.getRecipeById(recipeId)).thenReturn(expectedRecipe);

        ResponseEntity<RecipeDTO> response = recipeController.getRecipeById(recipeId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedRecipe, response.getBody());
    }

    @Test
    void updateRecipe_ValidIdAndRequest_UpdatesRecipe() {
        RecipeRequestDTO requestDTO = new RecipeRequestDTO("Updated Title", "Updated Description", Arrays.asList("Updated Ingredient1"), "updated_image.jpg");
        RecipeDTO updatedRecipe = new RecipeDTO(new Recipe());
        String recipeId = "testRecipeId";

        when(recipeService.updateRecipe(eq(recipeId), any(RecipeRequestDTO.class))).thenReturn(updatedRecipe);

        ResponseEntity<RecipeDTO> response = recipeController.updateRecipe(recipeId, requestDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedRecipe, response.getBody());
    }

    @Test
    void deleteRecipe_ValidId_DeletesRecipe() {
        String recipeId = "testRecipeId";

        doNothing().when(recipeService).deleteRecipe(recipeId);

        ResponseEntity<Void> response = recipeController.deleteRecipe(recipeId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(recipeService).deleteRecipe(recipeId);
    }
}
