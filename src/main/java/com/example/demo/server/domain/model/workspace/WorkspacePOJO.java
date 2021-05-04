package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.TaskPOJO;
import com.example.demo.server.domain.model.task.TaskSet;

import java.util.Collections;
import java.util.Set;

/**
 * ワークスペースPOJO
 */
public class WorkspacePOJO {
    final public String id;
    final public String name;
    final public Set<TaskPOJO> tasks;

    private WorkspacePOJO(String id, String name, Set<TaskPOJO> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    private WorkspacePOJO(String id, String name) {
        this(id, name, Collections.emptySet());
    }

    private WorkspacePOJO(Workspace workspace) {
        this(workspace.id.toString(), workspace.name, TaskPOJO.from(workspace.tasks));
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

    /**
     * ワークスペースを構築する
     *
     * @return ワークスペース
     */
    public Workspace build() {
        WorkspaceId id = WorkspaceId.of(this.id);
        TaskSet tasks = this.tasks.stream().map(TaskPOJO::build).collect(TaskPOJO.collector);
        return new Workspace(id, this.name, tasks);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final WorkspacePOJO that = (WorkspacePOJO) o;

        if (!this.id.equals(that.id)) return false;
        if (!this.name.equals(that.name)) return false;
        return this.tasks.equals(that.tasks);
    }

    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.tasks.hashCode();
        return result;
    }
}
