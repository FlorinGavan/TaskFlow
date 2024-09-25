package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.CommentDTO;
import com.example.TaskFlow.models.entities.Comment;
import com.example.TaskFlow.repositories.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Comment commentEntityToBeSaved = objectMapper.convertValue(commentDTO, Comment.class);
        Comment commentResponseEntity = commentRepository.save(commentEntityToBeSaved);
        return objectMapper.convertValue(commentResponseEntity, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> deleteComment() {
        return null;
    }

    @Override
    public List<CommentDTO> updateComment() {
        return null;
    }

    @Override
    public List<CommentDTO> getComment() {
        return null;
    }
}