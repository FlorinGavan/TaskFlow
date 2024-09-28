package com.example.TaskFlow.services;

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

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User updateValue = userRepository.save(objectMapper.convertValue(userDTO, User.class));
        return objectMapper.convertValue(updateValue, UserDTO.class);
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