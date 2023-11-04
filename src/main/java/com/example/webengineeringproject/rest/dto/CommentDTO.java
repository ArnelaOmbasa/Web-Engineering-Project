package com.example.webengineeringproject.rest.dto;

public class CommentDTO {
    private String commentId;
    private String text;
    private String authorId;
    private String recipeId;

    public CommentDTO(String comment) {
        this.text = comment;
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

    public String getAuthor() {
        return authorId;
    }

    public void setAuthor(String author) {
        this.authorId = author;
    }

    public String getRecipe() {
        return recipeId;
    }

    public void setRecipe(String recipe) {
        this.recipeId = recipe;
    }




}