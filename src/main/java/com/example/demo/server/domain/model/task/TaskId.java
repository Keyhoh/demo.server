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
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
