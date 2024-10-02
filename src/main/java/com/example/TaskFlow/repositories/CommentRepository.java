package com.example.TaskFlow.repositories;

import com.example.TaskFlow.models.entities.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
List<Comment> findByTaskId(Long taskId);
Optional<Comment> findCommentById(@NotNull Long id);
}