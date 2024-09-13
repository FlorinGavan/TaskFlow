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

@OneToMany
@JoinColumn(name ="task_id")
    private Task task;

@ManyToOne
@JoinColumn(name = "description")
    private String description;
}
