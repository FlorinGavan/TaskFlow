package com.example.TaskFlow.services;

import com.example.TaskFlow.models.dtos.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
     void deleteComment(Long id);
    CommentDTO updateComment(Long id , CommentDTO commentDTO);
    List<CommentDTO> getComments();
}
