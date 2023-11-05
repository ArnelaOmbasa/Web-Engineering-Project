package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.service.CommentService;
import com.example.webengineeringproject.core.service.RecipeService;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.CommentRequestDTO;
import com.example.webengineeringproject.rest.dto.RecipeDTO;
import com.example.webengineeringproject.rest.dto.RecipeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    private final CommentService commentService;
    public RecipeController(RecipeService recipeService, CommentService commentService) {
        this.recipeService = recipeService;
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeDTO createdRecipe = recipeService.createRecipe(recipeRequestDTO);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<RecipeDTO> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.GET)
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable String recipeId) {
        RecipeDTO recipe = recipeService.getRecipeById(recipeId);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.PUT)
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable String recipeId, @RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeDTO updatedRecipe = recipeService.updateRecipe(recipeId, recipeRequestDTO);
        if (updatedRecipe != null) {
            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{recipeId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRecipe(@PathVariable String recipeId) {
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
/*

Will be used and updated later I need more logic here like authentication for getting userId in the response body, for now I have basic CRUD operations for comment collection

    // Add a comment to a recipe
    @RequestMapping(value = "/{recipeId}/comments", method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> addCommentToRecipe(@PathVariable String recipeId, @RequestBody CommentRequestDTO commentRequestDTO) {
        CommentDTO commentDTO = commentService.createComment(commentRequestDTO.toEntity());
        return ResponseEntity.ok(commentDTO);
    }

    // Get all comments for a recipe
    @RequestMapping(value = "/{recipeId}/comments", method = RequestMethod.GET)
    public ResponseEntity<List<CommentDTO>> getAllCommentsForRecipe(@PathVariable String recipeId) {
        List<CommentDTO> comments = commentService.getCommentsForRecipe(recipeId);
        return ResponseEntity.ok(comments);
    }

    // Delete a comment
    @RequestMapping(value = "/{recipeId}/comments/{commentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable String recipeId, @PathVariable String commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }*/


}
