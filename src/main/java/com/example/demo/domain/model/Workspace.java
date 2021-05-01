package com.example.demo.domain.model;

import com.example.demo.domain.model.task.Task;
import com.example.demo.domain.model.task.TaskSet;

/**
 * ワークスペース
 */
public class Workspace {
    /**
     * 名前
     */
    String name;
    /**
     * タスク
     */
    TaskSet tasks;

    Workspace(String name) {
        this.name = name;
        this.tasks = TaskSet.empty();
    }

    public TaskSet add(Task task) {
        this.tasks = this.tasks.put(task);
        return this.tasks;
    }
}
