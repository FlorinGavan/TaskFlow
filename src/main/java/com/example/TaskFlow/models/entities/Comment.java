package com.example.TaskFlow.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "description")
//    private String description;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}