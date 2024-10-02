package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO ,Long creatorUserId);
    TaskDTO updateTask(Long taskId, TaskDTO taskDTO) ;
    List<TaskDTO> getAllTasks();
    void deleteTask(Long id);
    List<Task> findTaskByPriority(Task.Priority priority);
    TaskDTO assignedTask(Long taskId, Long userId);
//    Task updateTaskProgress(Long taskId, int progress);
//    Task markTaskAsCompleted(Long taskId);
//    List<Task> getTasksByAssignee(Long userId);
}