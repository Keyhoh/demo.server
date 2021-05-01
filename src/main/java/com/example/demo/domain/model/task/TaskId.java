package com.example.demo.domain.model.task;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TaskId taskId = (TaskId) o;

        return value.equals(taskId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
