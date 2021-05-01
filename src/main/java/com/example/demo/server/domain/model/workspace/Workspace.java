package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskSet;

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
     * ワークスペースの名前を変更する
     * @param name 新しい名前
     * @return ワークスペース
     */
    public Workspace rename(String name) {
        this.name = name;
        return this;
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

    /**
     * タスクを削除する
     *
     * @param task 削除するタスク
     * @return タスクが削除されたタスクセット
     */
    public TaskSet remove(Task task) {
        this.tasks = this.tasks.remove(task);
        return this.tasks;
    }
}
