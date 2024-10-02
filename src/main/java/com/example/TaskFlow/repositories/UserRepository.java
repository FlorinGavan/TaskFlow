package com.example.TaskFlow.repositories;

import com.example.TaskFlow.models.entities.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @NotNull
    Optional<User> findUserById(@NotNull Long id);
    Optional <User> findUserByEmail(String email);

}
