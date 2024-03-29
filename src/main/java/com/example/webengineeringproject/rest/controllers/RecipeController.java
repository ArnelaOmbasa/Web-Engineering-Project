package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.service.CommentService;
import com.example.webengineeringproject.core.service.RecipeService;
import com.example.webengineeringproject.rest.dto.RecipeDTO;
import com.example.webengineeringproject.rest.dto.RecipeRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@SecurityRequirement(name = "JWT Security")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    private final CommentService commentService;
    public RecipeController(RecipeService recipeService, CommentService commentService) {
        this.recipeService = recipeService;
        this.commentService = commentService;
    }


    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<RecipeDTO> createRecipe(
            @RequestBody RecipeRequestDTO recipeRequestDTO,
            Authentication authentication) {

       String ownerId = authentication.getName(); // Get the owner's ID from authentication
        RecipeDTO createdRecipe = recipeService.createRecipe(recipeRequestDTO, ownerId);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    //@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<RecipeDTO> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable String recipeId) {
        RecipeDTO recipe = recipeService.getRecipeById(recipeId);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable String recipeId, @RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeDTO updatedRecipe = recipeService.updateRecipe(recipeId, recipeRequestDTO);
        if (updatedRecipe != null) {
            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String recipeId) {
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/author/{username}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<List<RecipeDTO>> getRecipesByAuthorUsername(@PathVariable String username) {
        List<RecipeDTO> recipes = recipeService.getRecipesByAuthorUsername(username);
        return ResponseEntity.ok(recipes);
    }



}
