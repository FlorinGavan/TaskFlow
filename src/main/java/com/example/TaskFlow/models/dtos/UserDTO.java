package com.example.TaskFlow.models.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
