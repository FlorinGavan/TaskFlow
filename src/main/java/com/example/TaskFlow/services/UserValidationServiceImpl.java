package com.example.TaskFlow.services;

import com.example.TaskFlow.exceptions.UserCreateException;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserValidationServiceImpl implements UserValidationService {

    private final UserRepository userRepository;

    public UserValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
public  void validateEmail (String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (email.isEmpty()){
            throw  new UserCreateException("Please add an email");
        }
        if (user != null){
            throw new UserCreateException("Email already used. Try again with another email!");
        }

}

    @Override
    public void firstNameValidation(String firstName) throws UserCreateException {
        firstName = firstName.trim();

        if (firstName.isEmpty()) {
            throw new UserCreateException("First name cannot be empty");
        }
        if (firstName.trim().length() < 2) {
            throw new UserCreateException("First name is too short");
        }
        if (!firstName.matches("[a-zA-Z]+")) {
            throw new UserCreateException("Symbols and Numbers are not allowed on first name");
        }
        log.info("First name is valid {} ", firstName);
    }

    @Override
    public void lastNAmeValidation(String lastName) throws UserCreateException {
        lastName = lastName.trim();

        if (lastName.isEmpty()) {
            throw new UserCreateException("Last name cannot be empty");
        }
        if (lastName.trim().length() < 2) {
            throw new UserCreateException("Last name is too short");
        }
        if (!lastName.matches("[a-zA-Z]+")) {
            throw new UserCreateException("Symbols and Numbers are not allowed on last name");
        }
        log.info("Last name is valid {} ", lastName);
    }

}