package com.example.webengineeringproject.core.service;

import com.example.webengineeringproject.core.api.mailsender.MailSender;
import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private MailSender mailgunSender;

    @Autowired
    private MailSender sendgridSender;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public String sendEmailToAllUsers(String message) {
        List<User> users = userRepository.findAll();

        return sendgridSender.send(users, message);
    }
}
