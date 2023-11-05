package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import com.example.webengineeringproject.core.model.Comment;
import com.example.webengineeringproject.core.model.Recipe;
import com.example.webengineeringproject.core.repository.CommentRepository;
import com.example.webengineeringproject.rest.dto.CommentDTO;
import com.example.webengineeringproject.rest.dto.CommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        return comments
                .stream()
                .map(CommentDTO::new)
                .collect(toList());
    }

    public CommentDTO getCommentById(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) {
            throw new ResourceNotFoundException("The comment with the given ID does not exist.");
        }
        return new CommentDTO(comment.get());
    }

    public CommentDTO createComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return new CommentDTO(savedComment);
    }

    public CommentDTO updateComment(String commentId, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if (existingComment.isEmpty()) {
            throw new ResourceNotFoundException("The comment with the given ID does not exist.");
        }
        comment.setCommentId(existingComment.get().getCommentId());
        Comment updatedComment = commentRepository.save(comment);
        return new CommentDTO(updatedComment);
    }

    public void deleteComment(String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        comment.ifPresent(commentRepository::delete);
    }

    public List<CommentDTO> getCommentsForRecipe(String recipeId) {

        List<Comment> comments = commentRepository.findByRecipeId(recipeId);


        return comments.stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }
}
