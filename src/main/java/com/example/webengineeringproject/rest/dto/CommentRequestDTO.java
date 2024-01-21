package com.example.webengineeringproject.rest.dto;

import com.example.webengineeringproject.core.model.Comment;

public class CommentRequestDTO {

    private String text;
    public CommentRequestDTO() {
        // Default constructor
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Comment toEntity() {
        Comment comment = new Comment();
        comment.setText(this.text);

        return comment;
    }
}
