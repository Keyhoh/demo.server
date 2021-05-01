package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.TaskPOJO;

import java.util.List;

public class WorkspacePOJO {
    public String name;
    public List<TaskPOJO> tasks;

    public WorkspacePOJO(Workspace workspace) {
        this.name = workspace.name;
        this.tasks = TaskPOJO.from(workspace.tasks);
    }
}
