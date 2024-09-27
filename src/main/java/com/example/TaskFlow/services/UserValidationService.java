package com.example.TaskFlow.services;

public interface UserValidationService {

    void validateEmail(String email);
    void firstNameValidation(String firstName);
    void lastNAmeValidation(String lastName);
}