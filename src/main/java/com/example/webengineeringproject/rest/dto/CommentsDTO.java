package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Comment;

public class CommentsDTO {
    private String commentId;
    private String text;
    private String authorId;
    private String recipeId;


    public CommentsDTO() {
        // No-argument constructor
    }

    public CommentsDTO(Comment comment) {
        this.commentId = comment.getCommentId();
        this.text = comment.getText();
        this.authorId = comment.getAuthor();
        this.recipeId = comment.getRecipe();
    }
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }
}
