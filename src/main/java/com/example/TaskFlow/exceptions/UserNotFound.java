package com.example.TaskFlow.exceptions;

public class UserNotFound extends RuntimeException {

    public UserNotFound(Long id) {
        super("User with id: " + id + " not found ");
    }
}