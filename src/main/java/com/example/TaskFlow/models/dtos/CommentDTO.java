package com.example.TaskFlow.models.dtos;

import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.models.entities.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;

    private User user;

    private Task task;

    private String description;

}
