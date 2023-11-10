package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findFirstByEmailLike(String emailPattern);



    Optional<User> findByEmail(String email);
}
