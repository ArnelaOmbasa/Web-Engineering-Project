package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Comment;

public class CommentRequestDTO {

    private String text;
    public CommentRequestDTO() {
        // Default constructor
    }
    //public CommentRequestDTO(String text) {
       // this.text = text;
    //}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Assuming there's a method in the Comment class to handle only setting text
    public Comment toEntity() {
        Comment comment = new Comment();
        comment.setText(this.text);
        // The authorId and recipeId should be set elsewhere, e.g., in the service layer
        // comment.setAuthor(authorId);
        // comment.setRecipe(recipeId);
        return comment;
    }
}
