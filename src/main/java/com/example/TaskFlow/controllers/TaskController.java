package com.example.TaskFlow.controllers;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }
    @PostMapping("/api/tasks")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.createTask(taskDTO));
    }

//
//    @GetMapping
//    public ResponseEntity<List<Task>> getAllTasks() {
//        List<Task> tasks = taskService.getAllTasks();
//        return ResponseEntity.ok(tasks);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//        Task task = taskService.getTaskById(id);
//        return ResponseEntity.ok(task);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
//        Task task = taskService.updateTask(id, updatedTask);
//        return ResponseEntity.ok(task);
//    }
//
//    @PutMapping("/{id}/complete")
//    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
//        Task completedTask = taskService.markTaskAsComplete(id);
//        return ResponseEntity.ok(completedTask);
//
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//        taskService.deleteTask(id);
//        return ResponseEntity.noContent().build();
//    }
}
