package com.example.demo.server.presentation.controller;

import com.example.demo.server.domain.model.task.TaskPOJO;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import com.example.demo.server.infrastructure.datasource.task.TaskMapper;
import com.example.demo.server.infrastructure.datasource.workspace.WorkspaceMapper;
import com.example.demo.server.util.TaskUtil;
import com.example.demo.server.util.WorkspaceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Set;

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
        WorkspacePOJO target = WorkspaceUtil.generate();
        this.workspaceMapper.insertWorkspace(target);
        Set<TaskPOJO> tasks = TaskUtil.generate(4);
        this.taskMapper.insertTasks(target.id, tasks);

        Set<TaskPOJO> actual = this.taskController.add(target.id);

        Set<TaskPOJO> expected = this.workspaceMapper.selectWorkspaceTasks(target.id);
        assertThat(actual).isEqualTo(expected)
                .size().isEqualTo(5);
    }

    @Test
    void remove() {
        WorkspacePOJO workspace = WorkspaceUtil.generate();
        this.workspaceMapper.insertWorkspace(workspace);
        TaskPOJO target = TaskUtil.generate();
        this.taskMapper.insertTasks(workspace.id, Collections.singleton(target));

        Set<TaskPOJO> expected = TaskUtil.generate(4);
        this.taskMapper.insertTasks(workspace.id, expected);

        Set<TaskPOJO> actual = this.taskController.remove(workspace.id, target.id);

        assertThat(actual).isEqualTo(expected);
    }
}