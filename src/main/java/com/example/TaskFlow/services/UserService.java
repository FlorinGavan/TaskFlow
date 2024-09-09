package com.example.TaskFlow.services;


import com.example.TaskFlow.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    void deleteUser(Long id);


}