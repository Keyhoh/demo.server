package com.example.demo.domain.model.task;

/**
 * タスクID
 * TODO: 等価性
 * TODO: hash関数
 */
public class TaskId {
    /**
     * 新規IDを発行する
     *
     * @return 新規ID
     */
    public static TaskId generate() {
        return new TaskId();
    }
}
