package com.example.demo.server.application.repository;

import com.example.demo.server.domain.model.workspace.Workspace;

public interface WorkspaceRepository {
    void register(Workspace workspace);
}
