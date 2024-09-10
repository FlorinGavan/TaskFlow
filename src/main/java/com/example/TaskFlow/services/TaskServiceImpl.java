package com.example.TaskFlow.services;


import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.repositories.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ObjectMapper objectMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ObjectMapper objectMapper) {
        this.taskRepository = taskRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task taskEntity = objectMapper.convertValue(taskDTO, Task.class);
        Task taskEntityResponse = taskRepository.save(taskEntity);
        log.info("Task with id {} was saved", taskEntityResponse.getId());
        return objectMapper.convertValue(taskEntityResponse, TaskDTO.class);
    }
    //    public Task createTask(Task task) {
//        return taskRepository.save(task);
//    }
//
//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    public Task getTaskById(Long id) {
//        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
//    }
//
//    public Task updateTask(Long id, Task updatedTask) {
//        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
//        task.setTitle(updatedTask.getTitle());
//        task.setDescription(updatedTask.getDescription());
//        task.setDueDate(updatedTask.getDueDate());
//        task.setPriority(updatedTask.getPriority());
//        task.setProgress(updatedTask.getProgress());
//        task.setStatus(updatedTask.getStatus());
//        task.setAssignee(updatedTask.getAssignee());
//        return taskRepository.save(task);
//    }
//
//    public Task markTaskAsComplete(Long id) {
//        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
//        task.setStatus(Task.Status.COMPLETED);
//        task.setProgress(100);
//        return taskRepository.save(task);
//
//
//    }
//
//    public void deleteTask(Long id) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Task not found"));
//        taskRepository.delete(task);
//    }
}