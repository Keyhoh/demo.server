package com.example.demo.server.application.usecase.workspace;

import com.example.demo.server.application.service.WorkspaceService;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceUseCase {
    private final WorkspaceService workspaceService;

    public WorkspaceUseCase(final WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    public WorkspacePOJO create(String name) {
        Workspace workspace = this.workspaceService.create(name);
        return WorkspacePOJO.from(workspace);
    }

    public WorkspacePOJO findById(String value) {
        WorkspaceId id = WorkspaceId.of(value);
        Workspace workspace = this.workspaceService.findBy(id);
        return WorkspacePOJO.from(workspace);
    }

    public void rename(String targetId, String newName) {
        WorkspaceId id = WorkspaceId.of(targetId);
        Workspace workspace = this.workspaceService.findBy(id);
        this.workspaceService.rename(workspace, newName);
    }
}
