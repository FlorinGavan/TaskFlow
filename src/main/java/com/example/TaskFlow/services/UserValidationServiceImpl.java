package com.example.TaskFlow.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserValidationServiceImpl implements UserValidationService {
@Override
public  void emailValidation (String email) {
    if (!email.trim().contains("@") || email.trim().length() < 4){
        throw new RuntimeException("Email is not valid");
    }
}

    @Override
    public void firstNameValidation(String firstName) throws IllegalArgumentException {
        firstName = firstName.trim();

        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (firstName.trim().length() < 2) {
            throw new IllegalArgumentException("First name is too short");
        }
        if (!firstName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Symbols and Numbers are not allowed");
        }
        log.info("First name is valid {} ", firstName);
    }

    @Override
    public void lastNAmeValidation(String lastName) throws IllegalArgumentException {
        lastName = lastName.trim();

        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (lastName.trim().length() < 2) {
            throw new IllegalArgumentException("Last name is too short");
        }
        if (!lastName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Symbols and Numbers are not allowed");
        }
        log.info("Last name is valid {} ", lastName);
    }
}