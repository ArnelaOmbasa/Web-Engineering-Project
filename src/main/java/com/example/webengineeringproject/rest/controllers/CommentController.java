package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.service.CommentService;
import com.mongodb.client.model.Variable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }
}
