package com.example.webengineeringproject.api.impl.mailsender;

import com.example.webengineeringproject.core.api.mailsender.MailSender;
import com.example.webengineeringproject.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class MailgunSender implements MailSender {

    @Override
    public String send(List<User> users, String message) {
        for (User user: users) {
            System.out.println("Message sent to: " + user.getEmail());
        }
        return "Message: " + message + " | Sent via Mailgun.";
    }
}