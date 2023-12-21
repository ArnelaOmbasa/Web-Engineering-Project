package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RecipeRepository extends MongoRepository<Recipe,String> {
    @Query("{ 'title' : ?0 }")
    Optional<Recipe> findByTitle(String title);

}
