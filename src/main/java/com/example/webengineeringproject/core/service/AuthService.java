package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.exceptions.repository.ResourceNotFoundException;
import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.repository.UserRepository;
import com.example.webengineeringproject.rest.dto.LoginDTO;
import com.example.webengineeringproject.rest.dto.LoginRequestDTO;
import com.example.webengineeringproject.rest.dto.UserDTO;
import com.example.webengineeringproject.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO signUp(UserRequestDTO userRequestDTO) {
        userRequestDTO.setPassword(
                passwordEncoder.encode(userRequestDTO.getPassword())
        );
        User user = userRepository.save(userRequestDTO.toEntity());

        return new UserDTO(user);
    }

    public LoginDTO signIn(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
        );
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("This user does not exist."));
        String jwt = jwtService.generateToken(user,user.getUserId(),user.getRole(),user.getUsername());

        return new LoginDTO(jwt);
    }
    public UserDTO updateUser(String userId, UserRequestDTO payload) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }

        User updatedUser = payload.toEntity();
        // Check if the password was provided in the update request
        if (payload.getPassword() != null && !payload.getPassword().isEmpty()) {
            // Hash the new password before saving
            String hashedPassword = passwordEncoder.encode(payload.getPassword());
            updatedUser.setPassword(hashedPassword);
        } else {
            // Keep the old password if no new password is provided
            updatedUser.setPassword(existingUser.get().getPassword());
        }

        updatedUser.setUserId(existingUser.get().getUserId());
        userRepository.save(updatedUser);
        return new UserDTO(updatedUser);
    }
}
