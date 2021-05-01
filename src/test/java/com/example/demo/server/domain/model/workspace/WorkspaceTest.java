package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.Task;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorkspaceTest {
    @Test
    void initial_workspace() {
        Workspace workspace = Workspace.create("test workspace");
        WorkspacePOJO actual = new WorkspacePOJO(workspace);
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

    @Test
    void cannot_rename_to_blank() {
        Workspace workspace = Workspace.create("test workspace");
        String[] blanks = {
                null,
                "",
                " ", // space
                "  ", // two spaces
                "	",  // tab
                "\t",  // tab
                "　", // full-width space
                "\n",
                "\r\n"
        };
        for (String blank : blanks) {
            workspace.rename(blank);
            WorkspacePOJO actual = new WorkspacePOJO(workspace);
            assertThat(actual.name).isEqualTo("test workspace");
        }
    }

    @Test
    void put_task() {
        Workspace workspace = Workspace.create("test workspace");
        workspace.add(Task.prototype());
        WorkspacePOJO actual = new WorkspacePOJO(workspace);
        assertThat(actual.tasks).isNotEmpty();
    }

    @Test
    void put_task_twice() {
        Workspace workspace = Workspace.create("test workspace");
        workspace.add(Task.prototype());
        workspace.add(Task.prototype());
        WorkspacePOJO actual = new WorkspacePOJO(workspace);
        assertThat(actual.tasks).hasSize(2);
    }

    @Test
    void put_the_same_task() {
        Workspace workspace = Workspace.create("test workspace");
        Task task = Task.prototype();
        workspace.add(task);
        workspace.add(task);
        WorkspacePOJO actual = new WorkspacePOJO(workspace);
        assertThat(actual.tasks).hasSize(1);
    }

    @Test
    void remove_task() {
        Workspace workspace = Workspace.create("test workspace");
        Task task = Task.prototype();
        {
            workspace.add(task);
            WorkspacePOJO actual = new WorkspacePOJO(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
        {
            workspace.remove(task);
            WorkspacePOJO actual = new WorkspacePOJO(workspace);
            assertThat(actual.tasks).isEmpty();
        }
    }

    @Test
    void remove_the_other_task() {
        Workspace workspace = Workspace.create("test workspace");
        {
            workspace.add(Task.prototype());
            WorkspacePOJO actual = new WorkspacePOJO(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
        {
            workspace.remove(Task.prototype());
            WorkspacePOJO actual = new WorkspacePOJO(workspace);
            assertThat(actual.tasks).isNotEmpty();
        }
    }
}