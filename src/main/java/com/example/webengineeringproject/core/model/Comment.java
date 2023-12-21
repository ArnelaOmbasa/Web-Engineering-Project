package com.example.webengineeringproject.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
    @Id
        private String commentId;
        private String text;
        private String authorId;
        private String recipeId;

    public Comment() {
        this.commentId = commentId;
        this.text = text;
        this.authorId = authorId;
        this.recipeId = recipeId;
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

    public void setRecipe(String recipeId) {
        this.recipeId = recipeId;
    }
}
