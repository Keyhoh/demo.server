package com.example.demo.server.presentation.controller;

import com.example.demo.server.application.service.WorkspaceService;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workspaces")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    /**
     * ワークスペースを作成する
     *
     * @param name ワークスペース名
     * @return 新規ワークスペース
     */
    @PostMapping("create")
    public WorkspacePOJO create(@RequestBody String name) {
        return this.workspaceService.create(name);
    }
}
