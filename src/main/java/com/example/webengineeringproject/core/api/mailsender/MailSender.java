package com.example.webengineeringproject.core.api.mailsender;

import com.example.webengineeringproject.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MailSender {


        public String send(List<User> users, String message);
    }

