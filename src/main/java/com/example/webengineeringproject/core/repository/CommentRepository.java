package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepository {
    private List<Comment> comments;

    public CommentRepository() {
        this.comments = Arrays.asList(
                new Comment(1,"Great recipe!", 1, 1),
                new Comment(2,"Thanks for sharing!", 2, 1)
        );
    }

    public List<Comment> findAll() {
        return comments;
    }

    public Optional<Comment> findById(int id) {
        return comments.stream()
                .filter(comment -> comment.getCommentId() == id)
                .findFirst();
    }
}
