package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findFirstByEmailLike(String emailPattern);

    @Query(value="{'$or':[{'email': ?0}, {'username': ?1}]}")
    Optional<User> findByUsernameOrEmail(String username, String email);





    Optional<User> findByEmail(String email);
    User findByUsername(String username);
}
