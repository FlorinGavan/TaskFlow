package com.example.TaskFlow.models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String firstName, lastName;
    private UUID IDno;
}
//