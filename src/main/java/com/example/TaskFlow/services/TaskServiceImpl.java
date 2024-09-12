package com.example.TaskFlow.services;


import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repositories.TaskRepository;
import com.example.TaskFlow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        return null;
    }

//    @Override
//    public Task assignTask(Long taskId, Long userId) {
//        Optional<Task> taskOptional = taskRepository.findById(taskId);
//        Optional<User> userOptional = userRepository.findById(userId);
//
//        if (taskOptional.isPresent() && userOptional.isPresent()) {
//            Task task = taskOptional.get();
//            User user = userOptional.get();
//            task.setAssignee(user);
//            return taskRepository.save(task);
//        }
//        return null;
//    }
//    @Override
//    public Task updateTask(Long taskId, Task updatedTask) {
//        Optional<Task> taskOptional = taskRepository.findById(taskId);
//
//        if (taskOptional.isPresent()) {
//            Task task = taskOptional.get();
//            task.setTitle(updatedTask.getTitle());
//            task.setDescription(updatedTask.getDescription());
//            task.setDueDate(updatedTask.getDueDate());
//            task.setPriority(updatedTask.getPriority());
//            return taskRepository.save(task);
//        }
//        return null;
//    }
//    @Override
//    public Task updateTaskProgress(Long taskId, int progress) {
//        Optional<Task> taskOptional = taskRepository.findById(taskId);
//
//        if (taskOptional.isPresent()) {
//            Task task = taskOptional.get();
//            task.setProgress(progress);
//            return taskRepository.save(task);
//        }
//        return null;
//    }
//    @Override
//    public Task markTaskAsCompleted(Long taskId) {
//        Optional<Task> taskOptional = taskRepository.findById(taskId);
//
//        if (taskOptional.isPresent()) {
//            Task task = (Task) ((Optional<?>) taskOptional).get();
//            task.setProgress(100);
//            task.setCompleted(true);
//            return taskRepository.save(task);
//        }
//        return null;
//    }
//    @Override
//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    @Override
//    public Task getTaskById(Long taskId) {
//        return taskRepository.findById(taskId).orElse(null);
//    }
//
//    @Override
//    public void deleteTask(Long taskId) {
//        taskRepository.deleteById(taskId);
//    }
//
//    @Override
//    public List<Task> filterTasksByPriority(String priority) {
//        return taskRepository.findTasksByPriority(priority);
//    }
//
//    @Override
//    public List<Task> filterTasksByDueDate() {
//        Date currentDate = new Date();
//        return taskRepository.findTasksByDueDateAfter(currentDate);
//    }
//
//    @Override
//    public List<Task> getTasksByAssignee(Long userId) {
//        return taskRepository.findTasksByAssigneeId(userId);
//    }

}

