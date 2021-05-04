package com.example.demo.server.presentation.controller;

import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import com.example.demo.server.infrastructure.datasource.workspace.WorkspaceMapper;
import com.example.demo.server.util.WorkspaceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WorkspaceControllerTest {
    @Autowired
    private WorkspaceController workspaceController;
    @Autowired
    private WorkspaceMapper workspaceMapper;

    @Test
    void create() {
        WorkspacePOJO expected = this.workspaceController.create("workspace name");

        WorkspacePOJO actual = this.workspaceMapper.selectWorkspace(expected.id);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void get() {
        WorkspacePOJO expected = WorkspaceUtil.generate();
        this.workspaceMapper.insertWorkspace(expected);

        WorkspacePOJO actual = this.workspaceController.get(expected.id);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void rename() {
        WorkspacePOJO target = WorkspaceUtil.generate("target workspace");
        this.workspaceMapper.insertWorkspace(target);

        this.workspaceController.rename(target.id, "renamed workspace");

        WorkspacePOJO actual = this.workspaceMapper.selectWorkspace(target.id);
        assertThat(actual.name).isEqualTo("renamed workspace");
    }
}