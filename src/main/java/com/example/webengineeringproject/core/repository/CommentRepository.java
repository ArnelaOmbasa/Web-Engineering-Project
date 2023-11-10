package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    @Query("{ 'recipe.id' : ?0 }")
    List<Comment> findByRecipeId(String recipeId);

    @Query("{ 'recipeId' : ?0, 'text' : ?1 }")
    Optional<Comment> findByRecipeIdAndText(String recipeId, String commentText);


    // Custom query to find a comment by ID and Recipe ID for deletion
    @Query("{ 'commentId' : ?0, 'recipeId' : ?1 }")
    Optional<Comment> findByIdAndRecipeId(String commentId, String recipeId);
}
