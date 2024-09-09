package com.example.TaskFlow.models.entitys;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String commentText;
    private Timestamp createdAt;
}

