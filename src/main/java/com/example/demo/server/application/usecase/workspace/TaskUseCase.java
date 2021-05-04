package com.example.demo.server.application.usecase.workspace;

import com.example.demo.server.application.service.TaskService;
import com.example.demo.server.application.service.WorkspaceService;
import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskId;
import com.example.demo.server.domain.model.task.TaskPOJO;
import com.example.demo.server.domain.model.task.TaskSet;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskUseCase {
    private final TaskService taskService;
    private final WorkspaceService workspaceService;

    public TaskUseCase(final TaskService taskService, final WorkspaceService workspaceService) {
        this.taskService = taskService;
        this.workspaceService = workspaceService;
    }

    public List<TaskPOJO> add(String workspaceId) {
        Workspace workspace = this.workspaceService.findBy(WorkspaceId.of(workspaceId));
        TaskSet tasks = this.taskService.add(workspace);
        return TaskPOJO.from(tasks);
    }

    public List<TaskPOJO> remove(String workspaceId, String targetId) {
        Workspace workspace = this.workspaceService.findBy(WorkspaceId.of(workspaceId));
        Task task = this.taskService.findBy(TaskId.of(targetId));
        TaskSet tasks = this.taskService.remove(workspace, task);
        return TaskPOJO.from(tasks);
    }
}
