package com.example.demo.server.domain.model.workspace;

import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskSet;
import org.apache.commons.lang3.StringUtils;

/**
 * *ワークスペース
 * TODO: 不変オブジェクトにすべきか
 */
public class Workspace {
    /**
     * ID
     */
    final WorkspaceId id;
    /**
     * 名前
     */
    String name;
    /**
     * タスクセット
     */
    TaskSet tasks;

    Workspace(WorkspaceId id, String name, TaskSet tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public static Workspace create(String name) {
        return new Workspace(WorkspaceId.generate(), name, TaskSet.empty());
    }

    /**
     * ワークスペースの名前を変更する
     *
     * @param newName 新しい名前
     * @return ワークスペース
     */
    public Workspace renameTo(String newName) {
        if (StringUtils.isNoneBlank(newName)) {
            this.name = newName;
        }
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
