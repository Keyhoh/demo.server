package com.example.demo.server.presentation.controller;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
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

    @Test
    void create() {
        WorkspacePOJO actual = workspaceController.create("workspace name");
        assertThat(actual.id).isNotBlank();
        assertThat(actual.name).isEqualTo("workspace name");
        assertThat(actual.tasks).isEmpty();
    }

    @Test
    void get() {
        Workspace workspace = Workspace.create("new workspace");
        WorkspacePOJO expected = WorkspacePOJO.from(workspace);
        workspaceRepository.register(workspace);

        WorkspacePOJO actual = workspaceController.get(expected.id);
        assertThat(actual).isEqualTo(expected);
    }
}