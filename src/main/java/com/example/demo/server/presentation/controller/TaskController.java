package com.example.demo.server.presentation.controller;

import com.example.demo.server.application.usecase.workspace.TaskUseCase;
import com.example.demo.server.domain.model.task.TaskPOJO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("workspaces/{workspaceId}/tasks")
public class TaskController {
    private final TaskUseCase taskUseCase;

    public TaskController(final TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    @PostMapping
    public Set<TaskPOJO> add(@PathVariable final String workspaceId) {
        return this.taskUseCase.add(workspaceId);
    }

    @DeleteMapping("{id}")
    public Set<TaskPOJO> remove(@PathVariable final String workspaceId, @PathVariable final String id) {
        return this.taskUseCase.remove(workspaceId, id);
    }
}
