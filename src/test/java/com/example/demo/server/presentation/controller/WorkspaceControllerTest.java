package com.example.demo.server.presentation.controller;

import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WorkspaceControllerTest {
    @Autowired
    WorkspaceController workspaceController;

    @Test
    void create() {
        WorkspacePOJO actual = workspaceController.create("workspace name");
        assertThat(actual.id).isNotBlank();
        assertThat(actual.name).isEqualTo("workspace name");
        assertThat(actual.tasks).isEmpty();
    }
}