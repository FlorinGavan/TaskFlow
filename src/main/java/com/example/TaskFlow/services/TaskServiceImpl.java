package com.example.TaskFlow.services;


import com.example.TaskFlow.exceptions.TaskNotFound;
import com.example.TaskFlow.exceptions.UserNotFound;
import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.models.entities.User;
import com.example.TaskFlow.repositories.TaskRepository;
import com.example.TaskFlow.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final TaskValidationService taskValidationService;

    public TaskServiceImpl(ObjectMapper objectMapper, TaskValidationService taskValidationService, UserRepository userRepository, TaskRepository taskRepository) {
        this.objectMapper = objectMapper;
        this.taskValidationService = taskValidationService;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO, Long creatorUserId) {
        Task taskEntitySave = objectMapper.convertValue(taskDTO, Task.class);
        taskValidationService.validateTaskDto(taskDTO);

        User assignedUser = userRepository.findById(taskDTO.getAssignedUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        taskDTO.setAssignedUserId(assignedUser.getId());

        User creator = userRepository.findById(creatorUserId)
                .orElseThrow(() -> new RuntimeException("Creator not found"));
        taskEntitySave.setCreatedBy(creator);
        

        Task taskResponseEntity = taskRepository.save(taskEntitySave);
        log.info("Task was created with id {}", taskResponseEntity.getId());
        return objectMapper.convertValue(taskResponseEntity, TaskDTO.class);
    }

    @Override
    public TaskDTO assignedTask(Long taskId, Long userId) {
        Task task = taskRepository.findTaskById(taskId)
                .orElseThrow(() -> new TaskNotFound(taskId));
        User user = userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFound(userId));
        task.setAssignedUser(user);

        Task updatedTask = taskRepository.save(task);
        return objectMapper.convertValue(updatedTask, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findTaskById(id)
                .orElseThrow(() -> new TaskNotFound(id));

        if (taskDTO.getTitle() != null) {
            existingTask.setTitle(taskDTO.getTitle());
        }
        if (taskDTO.getDescription() != null) {
            existingTask.setDescription(taskDTO.getDescription());
        }
        if (taskDTO.getDueDate() != null) {
            existingTask.setDueDate(taskDTO.getDueDate());
        }
        if (taskDTO.getPriority() != null) {
            existingTask.setPriority(taskDTO.getPriority());
        }
        if (taskDTO.getStatus() != null) {
            existingTask.setStatus(taskDTO.getStatus());
        }
        if (taskDTO.getProgress() != 0) { // Consider a different approach for progress
            existingTask.setProgress(taskDTO.getProgress());
        }
//        if (taskDTO.getAssignee() != null) {
//            existingTask.setAssignedUser(taskDTO.getAssignee());
//        }
        Task updatedValue = taskRepository.save(existingTask);
        log.info("Task with id {} was updated.", updatedValue.getId());
        return objectMapper.convertValue(updatedValue, TaskDTO.class);
    }

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
    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task -> objectMapper.convertValue(task, TaskDTO.class))
                .toList();
    }

    @Override
    public void deleteTask(Long id) {
        log.info("Task with id {} was deleted", id);
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findTaskByPriority(Task.Priority priority) {
        return taskRepository.findByPriorityOrderByDueDateAsc(priority);
    }

//    @Override
//    public List<Task> getTasksByAssignee(Long userId) {
//        return taskRepository.findTasksByAssigneeId(userId);
//    }

}

