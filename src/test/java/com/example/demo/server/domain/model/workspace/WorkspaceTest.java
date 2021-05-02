package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WorkspaceTest {
    @Test
    void initial_workspace() {
        Workspace workspace = Workspace.create("test workspace");
        WorkspacePOJO actual = WorkspacePOJO.from(workspace);
        assertThat(actual.id).isNotBlank();
        assertThat(actual.name).isEqualTo("test workspace");
        assertThat(actual.tasks).isEmpty();
    }

    @Test
    void rename() {
        Workspace workspace = Workspace.create("test workspace");
        workspace.rename("new workspace name");
        assertThat(workspace.name).isEqualTo("new workspace name");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ", // space
            "  ", // two spaces
            "	",  // tab
            "\t",  // tab
            "　", // full-width space
            "\n",
            "\r\n"
    })
    void cannot_rename_to_blank(String blank) {
        Workspace workspace = Workspace.create("test workspace");
        workspace.rename(blank);
        WorkspacePOJO actual = WorkspacePOJO.from(workspace);
        assertThat(actual.name).isEqualTo("test workspace");
    }

    @Test
    void put_task() {
        Workspace workspace = Workspace.create("test workspace");
        workspace.add(Task.prototype());
        WorkspacePOJO actual = WorkspacePOJO.from(workspace);
        assertThat(actual.tasks).isNotEmpty();
    }

    @Test
    void put_task_twice() {
        Workspace workspace = Workspace.create("test workspace");
        workspace.add(Task.prototype());
        workspace.add(Task.prototype());
        WorkspacePOJO actual = WorkspacePOJO.from(workspace);
        assertThat(actual.tasks).hasSize(2);
    }

    @Test
    void put_the_same_task() {
        Workspace workspace = Workspace.create("test workspace");
        Task task = Task.prototype();
        workspace.add(task);
        workspace.add(task);
        WorkspacePOJO actual = WorkspacePOJO.from(workspace);
        assertThat(actual.tasks).hasSize(1);
    }

    @Test
    void remove_task() {
        Workspace workspace = Workspace.create("test workspace");
        Task task = Task.prototype();
        {
            workspace.add(task);
            WorkspacePOJO actual = WorkspacePOJO.from(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
        {
            workspace.remove(task);
            WorkspacePOJO actual = WorkspacePOJO.from(workspace);
            assertThat(actual.tasks).isEmpty();
        }
    }

    @Test
    void remove_the_other_task() {
        Workspace workspace = Workspace.create("test workspace");
        {
            workspace.add(Task.prototype());
            WorkspacePOJO actual = WorkspacePOJO.from(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
        {
            workspace.remove(Task.prototype());
            WorkspacePOJO actual = WorkspacePOJO.from(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
    }
}