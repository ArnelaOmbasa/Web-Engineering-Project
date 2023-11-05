package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    @Query("{ 'recipe.id' : ?0 }")
    List<Comment> findByRecipeId(String recipeId);
}
