package com.example.TaskFlow.services;

import com.example.TaskFlow.exceptions.UserNotFound;
import com.example.TaskFlow.models.dtos.UserDTO;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final UserValidationService userValidationService;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper, UserValidationService userValidationService) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
        this.userValidationService = userValidationService;
    }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userEntitySave = objectMapper.convertValue(userDTO, User.class);
        userValidationService.validateUserDto(userDTO);

        User userResponseEntity = userRepository.save(userEntitySave);
        log.info("User created with id: {}", userResponseEntity.getId());
        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }


    // Method to update a user partially
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFound(id));

        userValidationService.validateUserBeforeEditing(userDTO);
        if (userDTO.getFirstName() != null) {
            existingUser.setFirstName(userDTO.getFirstName());
        }
        if (userDTO.getLastName() != null) {
            existingUser.setLastName(userDTO.getLastName());
        }
        if (userDTO.getEmail() != null) {
            existingUser.setEmail(userDTO.getEmail());
        }

        User updatedUser = userRepository.save(existingUser);
        log.info("User with id {} was updated.", updatedUser.getId());
        return objectMapper.convertValue(updatedUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}