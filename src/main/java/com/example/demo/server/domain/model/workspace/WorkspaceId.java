package com.example.demo.server.domain.model.workspace;

import java.util.UUID;

/**
 * ワークスペース
 */
public class WorkspaceId {
    private final UUID value;

    private WorkspaceId(UUID value) {
        this.value = value;
    }

    public static WorkspaceId generate() {
        return new WorkspaceId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
