package com.example.webengineeringproject.core.exceptions.auth;

import com.example.webengineeringproject.core.exceptions.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends GeneralException {
    public UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT.value());
    }

    public UserAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }
}
