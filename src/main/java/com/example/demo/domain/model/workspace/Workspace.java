package com.example.demo.domain.model.workspace;

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
     * タスクセット
     */
    TaskSet tasks;

    public Workspace(String name) {
        this.name = name;
        this.tasks = TaskSet.empty();
    }

    /**
     * タスクを追加する
     *
     * @param task 追加するタスク
     * @return タスクが追加されたタスクセット
     */
    public TaskSet add(Task task) {
        this.tasks = this.tasks.put(task);
        return this.tasks;
    }
}
