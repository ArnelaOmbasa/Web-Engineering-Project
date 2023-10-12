package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {


        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        // Note: This will throw an exception if the user is not found. Consider exception handling.
        return userService.getUserById(id).orElse(null);
}
    @GetMapping("/send-to-all")
    public String sendEmailToAllUsers(@RequestParam String message) {
        return userService.sendEmailToAllUsers(message);
    }

}
