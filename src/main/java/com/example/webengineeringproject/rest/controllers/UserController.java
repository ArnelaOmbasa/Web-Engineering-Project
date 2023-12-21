package com.example.webengineeringproject.rest.controllers;

import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.model.enums.UserRole;
import com.example.webengineeringproject.core.service.UserService;
import com.example.webengineeringproject.rest.dto.UserDTO;
import com.example.webengineeringproject.rest.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "JWT Security")
public class UserController {


        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> register(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> login(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(userService.login(username, password));
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId, @RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/filter")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> filterUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.filterByEmail(email));
    }

    @RequestMapping(value = "/{userId}/role", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> updateRole(@PathVariable String userId, @RequestParam UserRole role) {
        userService.updateRole(userId, role);
        return ResponseEntity.noContent().build();
    }
}

