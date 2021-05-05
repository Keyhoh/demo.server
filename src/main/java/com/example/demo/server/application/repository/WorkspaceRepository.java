package com.example.demo.server.application.repository;

import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;

import java.util.Set;

public interface WorkspaceRepository {
    void register(Workspace workspace);

    Set<Workspace> findAll();

    Workspace findBy(WorkspaceId id);

    void update(Workspace workspace);
}
