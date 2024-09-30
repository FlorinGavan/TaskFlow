package com.example.TaskFlow.models.dtos;

import ch.qos.logback.core.status.OnPrintStreamStatusListenerBase;
import com.example.TaskFlow.models.entities.Task;
import com.example.TaskFlow.models.entities.User;
import jdk.jshell.Snippet;
import lombok.Data;
import org.apache.tomcat.util.http.parser.Priority;

import java.time.LocalDate;

@Data
public class TaskDTO {

    private Long id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private Priority priority;

    private User assignee;

    private int progress;

    private Task.Status status;

    public void setdescription(String testDescription) {
    }

    public void setdueDate(String testDueDate) {
    }

    public void setpriority(String testPriority) {
    }

    public void setassignee(String testAssignee) {
    }

    public void setprogress(String testProgress) {
    }

    public void setstatus(String testStatus) {
    }
}
