package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends MongoRepository<Recipe,String> {

}
