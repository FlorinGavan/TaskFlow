package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.CommentDTO;
import com.example.TaskFlow.repositories.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    private final ObjectMapper objectMapper;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(ObjectMapper objectMapper, CommentRepository commentRepository) {
        this.objectMapper = objectMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        return null;
    }
}

