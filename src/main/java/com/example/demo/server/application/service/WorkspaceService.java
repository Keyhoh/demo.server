package com.example.demo.server.application.service;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
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
        this.workspaceRepository.register(workspace);
        return WorkspacePOJO.from(Workspace.create(name));
    }

    /**
     * ワークスペースを取得する
     *
     * @param value ワークスペースID
     * @return ワークスペース
     */
    public WorkspacePOJO findById(String value) {
        WorkspaceId id = WorkspaceId.of(value);
        Workspace workspace = this.workspaceRepository.findBy(id);
        return WorkspacePOJO.from(workspace);
    }
}
