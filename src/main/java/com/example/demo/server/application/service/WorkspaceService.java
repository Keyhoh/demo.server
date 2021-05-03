package com.example.demo.server.application.service;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(final WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    /**
     * ワークスペースを作成する
     *
     * @param name ワークスペース名
     * @return 新規ワークスペース
     */
    public WorkspacePOJO create(String name) {
        Workspace workspace = Workspace.create(name);
        workspaceRepository.register(workspace);
        return WorkspacePOJO.from(Workspace.create(name));
    }
}
