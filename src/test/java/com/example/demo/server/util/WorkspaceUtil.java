package com.example.demo.server.util;

import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;

public class WorkspaceUtil {
    public static WorkspacePOJO generate(String name) {
        return WorkspacePOJO.from(Workspace.create(name));
    }

    public static WorkspacePOJO generate() {
        return WorkspaceUtil.generate("test workspace");
    }
}
