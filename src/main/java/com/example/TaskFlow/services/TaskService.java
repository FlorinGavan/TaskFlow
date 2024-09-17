package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);
//    Task assignTask(Long taskId, Long userId);
    TaskDTO updateTask(Long taskId, TaskDTO updatedTask);
//    Task updateTaskProgress(Long taskId, int progress);
//    Task markTaskAsCompleted(Long taskId);
//    List<Task> getAllTasks();
//    Task getTaskById(Long taskId);
//    void deleteTask(Long taskId);
//    List<Task> filterTasksByPriority(String priority);
//    List<Task> filterTasksByDueDate();
//    List<Task> getTasksByAssignee(Long userId);
}