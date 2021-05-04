package com.example.demo.server.application.repository;

import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;

public interface WorkspaceRepository {
    void register(Workspace workspace);

    Workspace findBy(WorkspaceId id);
}
