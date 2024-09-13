package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
}
