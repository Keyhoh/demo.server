package com.example.demo.server.application.service;

import com.example.demo.server.application.repository.WorkspaceRepository;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspaceId;
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
    public Workspace create(String name) {
        Workspace workspace = Workspace.create(name);
        this.workspaceRepository.register(workspace);
        return workspace;
    }

    /**
     * ワークスペースを取得する
     *
     * @param id ワークスペースID
     * @return ワークスペース
     */
    public Workspace findBy(WorkspaceId id) {
        return this.workspaceRepository.findBy(id);
    }


    /**
     * ワークスペースの名前を変更する
     *
     * @param workspace 対象ワークスペース
     * @param newName   新しい名前
     */
    public void rename(Workspace workspace, String newName) {
        workspace = workspace.renameTo(newName);
        this.workspaceRepository.update(workspace);
    }
}
