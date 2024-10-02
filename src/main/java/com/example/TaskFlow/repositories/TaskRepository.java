package com.example.TaskFlow.repositories;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<Task>findTaskById(@NotNull Long id);
    Optional<Task> findTaskByTitle(String title);
    List<Task> findByPriorityOrderByDueDateAsc(Task.Priority priority);
    List<Task> findTasksByDueDateAfter(Date currentDate);
//    List<Task> findTasksByAssigneeId(Long userId);
}