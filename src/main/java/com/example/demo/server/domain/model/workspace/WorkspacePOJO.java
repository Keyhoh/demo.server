package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.TaskPOJO;

import java.util.List;

/**
 * ワークスペースPOJO
 */
public class WorkspacePOJO {
    public String id;
    public String name;
    public List<TaskPOJO> tasks;

    public WorkspacePOJO(Workspace workspace) {
        this.id = workspace.id.toString();
        this.name = workspace.name;
        this.tasks = TaskPOJO.from(workspace.tasks);
    }

    /**
     * ワークスペースPOJOを生成する
     *
     * @param workspace ワークスペース
     * @return ワークスペースPOJO
     */
    public static WorkspacePOJO from(Workspace workspace) {
        return new WorkspacePOJO(workspace);
    }
}
