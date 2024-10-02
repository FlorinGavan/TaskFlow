package com.example.TaskFlow.services;

import com.example.TaskFlow.exceptions.CommentNotFound;
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
        log.info("Comment is added");
        return objectMapper.convertValue(commentResponseEntity, CommentDTO.class);
    }

    @Override
    public void deleteComment(Long id)
    {
        log.info("Comment was deleted");
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDTO updateComment(Long id ,CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findCommentById(id)
                .orElseThrow(() -> new CommentNotFound(id));

        if (commentDTO.getText() != null){
            existingComment.setText(commentDTO.getText());
        }
        Comment updatedValue = commentRepository.save(existingComment);
        log.info("Comment updated");
        return  objectMapper.convertValue(updatedValue, CommentDTO.class);
    }

    @Override
    public List<CommentDTO> getComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(comment -> objectMapper.convertValue(comment,CommentDTO.class)).toList();
    }
}