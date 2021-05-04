package com.example.demo.server.domain.model.task;

import java.util.UUID;

/**
 * タスクID
 */
public class TaskId {
    private final UUID value;

    private TaskId(UUID value) {
        this.value = value;
    }

    /**
     * 新規IDを発行する
     *
     * @return 新規ID
     */
    public static TaskId generate() {
        return new TaskId(UUID.randomUUID());
    }

    /**
     * UUIDからIDを構築する
     *
     * @param uuid UUID
     * @return タスクID
     */
    public static TaskId of(UUID uuid) {
        return new TaskId(uuid);
    }

    /**
     * StringからIDを構築する
     *
     * @param s ID String
     * @return タスクID
     */
    public static TaskId of(String s) {
        return TaskId.of(UUID.fromString(s));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TaskId taskId = (TaskId) o;

        return this.value.equals(taskId.value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
