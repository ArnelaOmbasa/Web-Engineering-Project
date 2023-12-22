package com.example.webengineeringproject.rest.websockets;

// MainSocketHandler.java
import com.example.webengineeringproject.core.model.User;
import com.example.webengineeringproject.core.service.JwtService;
import com.example.webengineeringproject.core.service.RecipeService;
import com.example.webengineeringproject.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MainSocketHandler extends TextWebSocketHandler {
    private final JwtService jwtService;
    private final UserService userService;
    private final RecipeService recipeService;
    public Map<String, WebSocketSession> sessions = new HashMap<>();

    @Autowired
    public MainSocketHandler(JwtService jwtService, UserService userService, RecipeService recipeService) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        User user = getUser(session);
        if (user == null) {
            return;
        }

        sessions.put(user.getUserId(), session);
        System.out.println("Session created for the user " + user.getUserId() + " where the session id is " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String messageReceived = message.getPayload();
        System.out.println("Message received: " + messageReceived);

        // Process the message (e.g., check if it's a comment notification) and notify users
        if (messageReceived.startsWith("COMMENT:")) {
            String[] parts = messageReceived.split(":", 2);
            if (parts.length == 2) {
                notifyRecipeOwnerAboutComment(parts[1]);
            }
        }
    }

    private void notifyRecipeOwnerAboutComment(String comment) throws IOException {
        String recipeId = extractRecipeIdFromComment(comment);
        String ownerId = recipeService.getOwnerId(recipeId);

        sendMessage(ownerId, "COMMENT: " + comment);
    }

    private String extractRecipeIdFromComment(String comment) {
        String[] parts = comment.split(" ", 2);
        return parts.length > 1 ? parts[0].split(":")[1] : "";
    }

    private User getUser(WebSocketSession session) throws IOException {
        List<String> headers = session.getHandshakeHeaders().getOrEmpty("authorization");
        if (headers.size() == 0) {
            session.close();
            return null;
        }

        String jwt = headers.get(0).substring(7);
        String userEmail = jwtService.extractUserName(jwt);

        UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
        return (User) userDetails;
    }

    public void broadcastMessage(String message) throws IOException {
        sessions.forEach((key, session) -> {
            try {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void sendMessage(String userId, String message) {
        WebSocketSession session = sessions.get(userId);
        if (session == null) {
            return;
        }

        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

