package com.example.webengineeringproject.core.repository;

import com.example.webengineeringproject.core.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {


        private List<User> users;

        public UserRepository() {
            this.users = Arrays.asList(
                    new User(1,"CookMaster", "securepassword", "cookmaster@email.com", User.Role.ADMIN, Arrays.asList(1, 2), Arrays.asList(1)),
                    new User(2,"RecipeFan", "anothersecurepassword", "recipefan@email.com", User.Role.USER, Arrays.asList(3), Arrays.asList(2, 3)));
        }


        public List<User> findAll() {
            return users;
        }

        public Optional<User> findById(int id) {
            return users.stream()
                    .filter(user -> user.getUserId() == id)
                    .findFirst();
        }
}
