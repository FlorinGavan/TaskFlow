package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
    List<CommentDTO> deleteComment();
    List<CommentDTO> updateComment();
    List<CommentDTO> getComment();
}
