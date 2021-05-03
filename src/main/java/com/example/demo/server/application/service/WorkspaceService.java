package com.example.demo.server.application.service;

import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    public WorkspacePOJO create(String name) {
        return WorkspacePOJO.from(Workspace.create(name));
    }
}
