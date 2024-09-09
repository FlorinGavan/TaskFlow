package com.example.TaskFlow.models.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID IDno;
    private String firstName, lastName;
}
//