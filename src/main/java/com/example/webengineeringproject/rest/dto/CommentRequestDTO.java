package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Comment;

public class CommentRequestDTO {

    private String text;
    private String authorId;
    private String recipeId;

    public CommentRequestDTO(String text, String authorId, String recipeId) {
        this.text = text;
        this.authorId = authorId;
        this.recipeId = recipeId;
    }

    public Comment toEntity() {
        Comment comment = new Comment();
        comment.setText(this.text);
        comment.setAuthor(this.authorId);
        comment.setRecipe(this.recipeId);
        return comment;
    }
}
