package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.TaskDTO;

public interface TaskValidationService {

    void validateTaskDto(TaskDTO taskDTO);
}