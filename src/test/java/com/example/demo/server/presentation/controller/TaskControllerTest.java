package com.example.demo.server.presentation.controller;

import com.example.demo.server.domain.model.task.TaskPOJO;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import com.example.demo.server.infrastructure.datasource.task.TaskMapper;
import com.example.demo.server.infrastructure.datasource.workspace.WorkspaceMapper;
import com.example.demo.server.util.TaskUtil;
import com.example.demo.server.util.WorkspaceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskControllerTest {
    @Autowired
    private WorkspaceMapper workspaceMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskController taskController;

    @Test
    void add() {
        WorkspacePOJO workspace = WorkspaceUtil.generate();
        this.workspaceMapper.insertWorkspace(workspace);
        List<TaskPOJO> tasks = TaskUtil.generate(16);
        this.taskMapper.insertTasks(workspace.id, tasks);

        List<TaskPOJO> actual = this.taskController.add(workspace.id);

        List<TaskPOJO> expected = this.workspaceMapper.selectWorkspaceTasks(workspace.id);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void remove() {
        WorkspacePOJO workspace = WorkspaceUtil.generate();
        this.workspaceMapper.insertWorkspace(workspace);
        List<TaskPOJO> tasks = TaskUtil.generate(16);
        this.taskMapper.insertTasks(workspace.id, tasks);

        List<TaskPOJO> actual = this.taskController.add(workspace.id);

        List<TaskPOJO> expected = this.workspaceMapper.selectWorkspaceTasks(workspace.id);
        assertThat(actual).isEqualTo(expected);
    }
}