package com.example.demo.server.domain.model.workspace;

import java.util.UUID;

/**
 * ワークスペースID
 */
public class WorkspaceId {
    private final UUID value;

    private WorkspaceId(UUID value) {
        this.value = value;
    }

    /**
     * 新規IDを発行する
     *
     * @return 新規ID
     */
    public static WorkspaceId generate() {
        return new WorkspaceId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
