package com.example.demo.server.application.repository;

import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskId;
import com.example.demo.server.domain.model.workspace.Workspace;

public interface TaskRepository {
    Task findBy(TaskId id);

    void save(Workspace workspace);
}
