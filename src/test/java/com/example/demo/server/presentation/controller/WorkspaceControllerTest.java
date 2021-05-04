package com.example.demo.server.presentation.controller;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WorkspaceControllerTest {
    @Autowired
    WorkspaceController workspaceController;
    @Autowired
    WorkspaceRepository workspaceRepository;

    private Workspace workspace() {
        Workspace workspace = Workspace.create("new workspace");
        this.workspaceRepository.register(workspace);
        return workspace;
    }

    @Test
    void create() {
        WorkspacePOJO expected = this.workspaceController.create("workspace name");

        Workspace actual = this.workspaceRepository.findBy(WorkspaceId.of(expected.id));
        assertThat(actual).isNotNull();
        assertThat(WorkspacePOJO.from(actual)).isEqualTo(expected);
    }

    @Test
    void get() {
        Workspace workspace = workspace();
        WorkspacePOJO expected = WorkspacePOJO.from(workspace);

        WorkspacePOJO actual = this.workspaceController.get(expected.id);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void rename() {
        Workspace workspace = workspace();
        WorkspacePOJO target = WorkspacePOJO.from(workspace);

        this.workspaceController.rename(target.id, "renamed workspace");

        Workspace renamed = this.workspaceRepository.findBy(WorkspaceId.of(target.id));
        WorkspacePOJO actual = WorkspacePOJO.from(renamed);
        assertThat(actual.name).isEqualTo("renamed workspace");
    }
}