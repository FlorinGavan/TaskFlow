package com.example.TaskFlow.services;

import com.example.TaskFlow.exceptions.UserCreateException;
import com.example.TaskFlow.models.dtos.UserDTO;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
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
    public void validateUserDto(UserDTO userDTO) {
        Optional<User> user = userRepository.findUserByEmail(userDTO.getEmail());

        if (userDTO.getFirstName().isEmpty()) {
            throw new UserCreateException("First name is required");
        }
        if (userDTO.getLastName().isEmpty()) {
            throw new UserCreateException("Last name is required");
        }
        if (userDTO.getFirstName().length() < 2) {
            throw new UserCreateException("Your first name is too short");
        }
        if (userDTO.getLastName().length() < 2) {
            throw new UserCreateException("Your last name is too short");
        }
        if (!userDTO.getFirstName().matches("[a-zA-Z]+") || !userDTO.getLastName().matches("[a-zA-Z]+")) {
            throw new UserCreateException("Numbers and Symbols are not allowed");
        }
        if (userDTO.getEmail().isEmpty()) {
            throw new UserCreateException("Please add an email ");
        }
        if (user.isPresent()) {
            throw new UserCreateException("Email already used. Try again with another email!");
        }
    }

    @Override
    public void validateUserBeforeEditing(UserDTO userDTO) {
         Optional<User> user = userRepository.findUserByEmail(userDTO.getEmail());
            if (user.isPresent()) {
            throw new UserCreateException("Email already used. Try again with another email!");
        }
    }
}