package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.service.CommentService;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.CommentRequestDTO;
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
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        List<CommentDTO> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Retrieve a single comment by its ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable String id) {
        CommentDTO comment = commentService.getCommentById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new comment
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        Comment comment = commentRequestDTO.toEntity();
        CommentDTO createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    // Update an existing comment
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommentDTO> updateComment(@PathVariable String id, @RequestBody Comment comment) {
        CommentDTO updatedComment = commentService.updateComment(id, comment);
        if (updatedComment != null) {
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a comment
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
