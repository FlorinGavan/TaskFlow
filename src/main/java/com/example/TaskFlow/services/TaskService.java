package com.example.TaskFlow.services;

import com.example.TaskFlow.models.entities.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
//    Task assignTask(Long taskId, Long userId);
//    Task updateTask(Long taskId, Task updatedTask);
//    Task updateTaskProgress(Long taskId, int progress);
//    Task markTaskAsCompleted(Long taskId);
//    List<Task> getAllTasks();
//    Task getTaskById(Long taskId);
//    void deleteTask(Long taskId);
//    List<Task> filterTasksByPriority(String priority);
//    List<Task> filterTasksByDueDate();
//    List<Task> getTasksByAssignee(Long userId);
}