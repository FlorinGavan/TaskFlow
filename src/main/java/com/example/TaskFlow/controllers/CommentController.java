package com.example.TaskFlow.controllers;

import com.example.TaskFlow.models.dtos.CommentDTO;
import com.example.TaskFlow.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/api/comment/{id}")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }
}
