package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.models.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface TaskService {
    TaskDTO createTask(TaskDTO taskDTO);

//    Task createTask(Task task);
//
//    HashMap<User, Task> assignTask();
//
//    Task updateProgress();
//
//    Task isCompleted();
//
//    Set<Task> viewAllTasks();
//
//    Task getTaskReport();
//
//    Task commetnTask();
//
//    List<Task> sortTasks();

    TaskDTO createTask(TaskDTO taskDTO);
}