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

    /**
     * ワークスペースを作成する
     *
     * @param name ワークスペース名
     * @return 新規ワークスペース
     */
    public WorkspacePOJO create(String name) {
        Workspace workspace = this.workspaceService.create(name);
        return WorkspacePOJO.from(workspace);
    }

    /**
     * ワークスペースを取得する
     *
     * @param value ワークスペースID
     * @return ワークスペース
     */
    public WorkspacePOJO findById(String value) {
        WorkspaceId id = WorkspaceId.of(value);
        Workspace workspace = this.workspaceService.findBy(id);
        return WorkspacePOJO.from(workspace);
    }

    /**
     * ワークスペースの名前を変更する
     * @param targetId 対象ワークスペース
     * @param newName 新しい名前
     */
    public void rename(String targetId, String newName) {
        WorkspaceId id = WorkspaceId.of(targetId);
        Workspace workspace = this.workspaceService.findBy(id);
        this.workspaceService.rename(workspace, newName);
    }
}
