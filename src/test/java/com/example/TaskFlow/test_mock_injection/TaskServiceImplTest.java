package com.example.TaskFlow.test_mock_injection;

import com.example.TaskFlow.models.dtos.TaskDTO;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.repositories.TaskRepository;
import com.example.TaskFlow.services.TaskServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void testCreateTask() {
        //given
        TaskDTO requestTaskDTO = new TaskDTO();
        requestTaskDTO.setId(Long.valueOf("Test id"));
        requestTaskDTO.setTitle("Test title");
        requestTaskDTO.setdescription("Test description");
        requestTaskDTO.setdueDate("Test dueDate");
        requestTaskDTO.setpriority("Test priority");
        requestTaskDTO.setassignee("Test assignee");
        requestTaskDTO.setprogress("Test progress");
        requestTaskDTO.setstatus("Test status");

        Task taskEntity = new Task();
        taskEntity.setId(1L);
        taskEntity.setTitle("Test title");
        taskEntity.setdescription("Test description");
        taskEntity.setdueDate("Test dueDate");
        taskEntity.setpriority("Test priority");
        taskEntity.setassignee("Test assignee");
        taskEntity.setprogress("Test progress");
        taskEntity.setstatus("Test status");

        Task savedTaskEntity = new Task();
        savedTaskEntity.setId(1L);
        savedTaskEntity.setTitle("Test title");
        savedTaskEntity.setdescription("Test description");
        savedTaskEntity.setdueDate("Test dueDate");
        savedTaskEntity.setpriority("Test priority");
        savedTaskEntity.setassignee("Test assignee");
        savedTaskEntity.setprogress("Test progress");
        savedTaskEntity.setstatus("Test status");

        when(objectMapper.convertValue(requestTaskDTO, Task.class)).thenReturn(taskEntity);
        when(taskRepository.save(taskEntity)).thenReturn(taskEntity);

        //when
        TaskDTO savedTaskDTO = taskService.createTask(requestTaskDTO);

        //then
        verify(taskRepository, times(1)).save(taskEntity);
        assertEquals(requestTaskDTO.getAssignee(), savedTaskDTO.getAssignee());
        assertEquals(requestTaskDTO.getTitle(), savedTaskDTO.getTitle());

    }
}
