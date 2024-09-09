package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.UserDTO;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userEntitySave = objectMapper.convertValue(userDTO, User.class);
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