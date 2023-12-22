package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.repository.RecipeRepository;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.RecipeDTO;
import com.example.webengineeringproject.rest.dto.RecipeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;


    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

        return recipes
                .stream()
                .map(RecipeDTO::new)
                .collect(toList());
    }

    public RecipeDTO getRecipeById(String recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe with the given ID does not exist.");
        }
        return new RecipeDTO(recipe.get());
    }
/*
    public RecipeDTO createRecipe(RecipeRequestDTO recipeRequestDTO) {
        Recipe recipe = recipeRepository.save(recipeRequestDTO.toEntity());
        return new RecipeDTO(recipe);
    }*/
public RecipeDTO createRecipe(RecipeRequestDTO recipeRequestDTO, String ownerId) {
    Recipe recipe = recipeRequestDTO.toEntity();
    recipe.setOwnerId(ownerId); // Set the owner's ID
    Recipe savedRecipe = recipeRepository.save(recipe);
    return new RecipeDTO(savedRecipe);
}

    public RecipeDTO updateRecipe(String recipeId, RecipeRequestDTO recipeRequestDTO) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(recipeId);
        if (existingRecipe.isEmpty()) {
            throw new ResourceNotFoundException("The recipe with the given ID does not exist.");
        }
        Recipe updatedRecipe = recipeRequestDTO.toEntity();
        updatedRecipe.setRecipeId(existingRecipe.get().getRecipeId());
        updatedRecipe = recipeRepository.save(updatedRecipe);
        return new RecipeDTO(updatedRecipe);
    }

    public void deleteRecipe(String recipeId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        recipe.ifPresent(recipeRepository::delete);
    }
    public void addCommentToRecipe(String recipeId, Comment comment) throws ChangeSetPersister.NotFoundException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Add the comment to the recipe's comments list
        recipe.getComments().add(String.valueOf(comment));

        // Update the recipe in the database
        recipeRepository.save(recipe);
    }


}

