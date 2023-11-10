package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.repository.CommentRepository;
import com.example.webengineeringproject.core.repository.RecipeRepository;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.CommentRequestDTO;
import com.example.webengineeringproject.rest.dto.CommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;

    public CommentService(CommentRepository commentRepository, RecipeService recipeService, RecipeRepository recipeRepository) {
        this.commentRepository = commentRepository;
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }

    public List<CommentsDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        return comments
                .stream()
                .map(CommentsDTO::new)
                .collect(toList());
    }

    public CommentsDTO getCommentById(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            throw new ResourceNotFoundException("The comment with the given ID does not exist.");
        }
        return new CommentsDTO(comment.get());
    }

    /*public CommentDTO createComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return new CommentDTO(savedComment);
    }*/

    public CommentsDTO updateComment(String commentId, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if (existingComment.isEmpty()) {
            throw new ResourceNotFoundException("The comment with the given ID does not exist.");
        }
        comment.setCommentId(existingComment.get().getCommentId());
        Comment updatedComment = commentRepository.save(comment);
        return new CommentsDTO(updatedComment);
    }

    public void deleteComment(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        comment.ifPresent(commentRepository::delete);
    }


        public List<CommentsDTO> getCommentsForRecipe(String recipeId) {
            Recipe recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));

            List<String> commentTexts = recipe.getComments();

            // Create CommentDTO objects for the comment texts
            List<CommentsDTO> commentDTOs = new ArrayList<>();
            for (String text : commentTexts) {
                CommentsDTO commentDTO = new CommentsDTO();
                commentDTO.setText(text);
                commentDTO.setRecipeId(recipeId); // Set the recipeId
                commentDTOs.add(commentDTO);
            }

            return commentDTOs;




        }






    public CommentsDTO addCommentToRecipe(String recipeId, CommentRequestDTO commentRequestDTO) throws ChangeSetPersister.NotFoundException {
        // Retrieve the Recipe document by ID
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Create a new Comment entity
        Comment comment = new Comment();
        comment.setText(commentRequestDTO.getText());
        comment.setRecipe(recipeId); // Set the recipe ID

        // Save the Comment entity
        Comment savedComment = commentRepository.save(comment);

        // Add the comment text to the Recipe's comments list as a string
        recipe.getComments().add(commentRequestDTO.getText());

        // Update the Recipe document
        recipeRepository.save(recipe);

        return new CommentsDTO(savedComment);
    }


    public boolean deleteCommentByText(String recipeId, String commentText) {
        Optional<Comment> comment = commentRepository.findByRecipeIdAndText(recipeId, commentText);
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());

            Optional<Recipe> recipe = recipeRepository.findById(recipeId);
            if (recipe.isPresent()) {
                recipe.get().removeComment(commentText);
                recipeRepository.save(recipe.get());
            }

            return true;
        }
        return false;
    }
}
