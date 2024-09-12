package com.example.TaskFlow.repositories;


import com.example.TaskFlow.models.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByPriority(String priority);
    List<Task> findTasksByDueDateAfter(Date currentDate);
    List<Task> findTasksByAssigneeId(Long userId);
}