package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.api.mailsender.MailSender;
import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.model.enums.UserRole;
import com.example.webengineeringproject.core.repository.UserRepository;
import com.example.webengineeringproject.rest.dto.UserDTO;
import com.example.webengineeringproject.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService  {
    private final UserRepository userRepository;

    @Autowired
    private MailSender mailgunSender;

    @Autowired
    private MailSender sendgridSender;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO register(UserRequestDTO payload) {
        User user = userRepository.save(payload.toEntity());

        return new UserDTO(user);
    }

    public UserDTO login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        return new UserDTO(user);
    }

    public UserDTO getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        return new UserDTO(user.get());
    }

    public UserDTO updateUser(String userId, UserRequestDTO payload) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        User updatedUser = payload.toEntity();
        updatedUser.setUserId(existingUser.get().getUserId());
        userRepository.save(updatedUser);
        return new UserDTO(updatedUser);
    }

    public void deleteUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(userRepository::delete);
    }

    public void updateRole(String userId, UserRole role) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        User user = userOpt.get();
        user.setRole(role);
        userRepository.save(user);
    }

    public UserDTO filterByEmail(String email) {
        Optional<User> user = userRepository.findFirstByEmailLike(email);

        return user.map(UserDTO::new).orElse(null);
    }



    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsernameOrEmail(username, username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

}
