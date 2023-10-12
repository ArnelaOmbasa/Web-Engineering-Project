package com.example.webengineeringproject.core.model;

public class Comment {
    private int commentId;
    private String content;
    private int userId;
    private int recipeId;

    public Comment(int commentId,String content, int userId, int recipeId) {
        this.commentId = commentId;
        this.content = content;
        this.userId = userId;
        this.recipeId = recipeId;
    }

    // Getters and setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
