package com.example.TaskFlow.services;

import com.example.TaskFlow.exceptions.TaskCreateException;
import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskValidationServiceImpl implements TaskValidationService {

    private final TaskRepository taskRepository;

    public TaskValidationServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void validateTaskDto(TaskDTO taskDTO) {
      Optional<Task> tasked =  taskRepository.findTaskByTitle(taskDTO.getTitle());

        if (taskDTO.getTitle().isEmpty()){
            throw new TaskCreateException("Task title is required");
        }
        if(tasked.isPresent()){
            throw new TaskCreateException("Task already created. Create another task!");
        }
    }
}