package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.UserDTO;

public interface UserValidationService {

 void validateUserDto (UserDTO userDTO);
 void validateUserBeforeEditing(UserDTO userDTO);
}