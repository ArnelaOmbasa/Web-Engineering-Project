package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.service.CommentService;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.CommentRequestDTO;
import com.example.webengineeringproject.rest.dto.CommentsDTO;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Retrieve all comments
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CommentsDTO>> getAllComments() {
        List<CommentsDTO> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Retrieve a single comment by its ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommentsDTO> getCommentById(@PathVariable String id) {
        CommentsDTO comment = commentService.getCommentById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Update an existing comment
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommentsDTO> updateComment(@PathVariable String id, @RequestBody Comment comment) {
        CommentsDTO updatedComment = commentService.updateComment(id, comment);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a comment by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Retrieve all comments for a specific recipe
    @RequestMapping(value = "/{recipeId}/comment", method = RequestMethod.GET)
    public ResponseEntity<List<CommentsDTO>> getCommentsByRecipeId(@PathVariable String recipeId) {
        List<CommentsDTO> comments = commentService.getCommentsForRecipe(recipeId);
        if (comments != null && !comments.isEmpty()) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a comment to a recipe
    @RequestMapping(value = "/{recipeId}/comment", method = RequestMethod.POST)
    public ResponseEntity<CommentsDTO> addCommentToRecipe(
            @PathVariable String recipeId,
            @RequestBody CommentRequestDTO commentRequestDTO) throws ChangeSetPersister.NotFoundException {
        // Now you can access commentRequestDTO.getText() without errors
        CommentsDTO addedComment = commentService.addCommentToRecipe(recipeId, commentRequestDTO);

        return new ResponseEntity<>(addedComment, HttpStatus.CREATED);
    }



    // Delete a comment by ID within the scope of a specific recipe
    @RequestMapping(value = "/{recipeId}/{commentText}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable String recipeId, @PathVariable String commentText) {
        boolean isDeleted = commentService.deleteCommentByText(recipeId, commentText);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


     /* // Create a new comment - I think it is better option to add a comment on the recipe with recipeId like I did above
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        Comment comment = commentRequestDTO.toEntity();
        CommentDTO createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }*/


}
