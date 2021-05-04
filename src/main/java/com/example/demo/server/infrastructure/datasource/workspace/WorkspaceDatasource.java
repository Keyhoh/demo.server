package com.example.demo.server.infrastructure.datasource.workspace;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.stereotype.Repository;

@Repository
public class WorkspaceDatasource implements WorkspaceRepository {
    private final WorkspaceMapper workspaceMapper;

    public WorkspaceDatasource(final WorkspaceMapper workspaceMapper) {
        this.workspaceMapper = workspaceMapper;
    }

    @Override
    public void register(final Workspace workspace) {
        this.workspaceMapper.insertWorkspace(WorkspacePOJO.from(workspace));
    }

    @Override
    public Workspace findBy(final WorkspaceId id) {
        WorkspacePOJO workspacePOJO = this.workspaceMapper.selectWorkspace(id.toString());
        return workspacePOJO.build();
    }
}
