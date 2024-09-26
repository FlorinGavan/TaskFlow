package com.example.TaskFlow.services;

public interface UserValidationService {

    void emailValidation(String email);
    void firstNameValidation(String firstName);
    void lastNAmeValidation(String lastName);
}