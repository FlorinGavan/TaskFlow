package com.example.TaskFlow.integration_tests;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.dtos.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateTaskShouldPass() throws Exception {
        TaskDTO requestTaskDTO = new TaskDTO();
        requestTaskDTO.setId(Long.valueOf("test id 12"));
        requestTaskDTO.setTitle("test title");
        requestTaskDTO.setdescription("test description");
        requestTaskDTO.setdueDate("test dueDate");
        requestTaskDTO.setpriority("test priority");
        requestTaskDTO.setassignee("test assignee");
        requestTaskDTO.setprogress("test progress");
        requestTaskDTO.setstatus("test status");

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestTaskDTO)))
                .andExpect(status().isOk());
    }
}
