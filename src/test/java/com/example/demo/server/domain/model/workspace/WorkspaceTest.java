package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskPOJO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WorkspaceTest {
    @Test
    void initial_taskSet_is_empty() {
        Workspace workspace = new Workspace("test workspace");
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
        assertThat(actual).isEmpty();
    }

    @Test
    void put_task() {
        Workspace workspace = new Workspace("test workspace");
        workspace.add(Task.prototype());
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
        assertThat(actual).isNotEmpty();
    }

    @Test
    void put_task_twice() {
        Workspace workspace = new Workspace("test workspace");
        workspace.add(Task.prototype());
        workspace.add(Task.prototype());
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
        assertThat(actual).hasSize(2);
    }

    @Test
    void put_the_same_task() {
        Workspace workspace = new Workspace("test workspace");
        Task task = Task.prototype();
        workspace.add(task);
        workspace.add(task);
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
        assertThat(actual).hasSize(1);
    }

    @Test
    void remove_task() {
        Workspace workspace = new Workspace("test workspace");
        Task task = Task.prototype();
        {
            workspace.add(task);
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
            assertThat(actual).isNotEmpty();
        }
        {
            workspace.remove(task);
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
            assertThat(actual).isEmpty();
        }
    }

    @Test
    void remove_the_other_task() {
        Workspace workspace = new Workspace("test workspace");
        {
            workspace.add(Task.prototype());
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
            assertThat(actual).isNotEmpty();
        }
        {
            workspace.remove(Task.prototype());
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(workspace.tasks);
            assertThat(actual).isNotEmpty();
        }
    }
}