package com.example.demo.server.domain.model.task;

import org.apache.commons.lang3.StringUtils;

/**
 * *タスク
 * TODO: ステータス
 * TODO: 期限
 */
public class Task {
    /**
     * ID
     */
    final TaskId id;
    /**
     * タイトル
     */
    String title;
    /**
     * 詳細
     */
    String description;

    Task(TaskId id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * 基礎タスクを生成する
     *
     * @return 基礎タスク
     */
    public static Task prototype() {
        return new Task(TaskId.generate(), "", "");
    }

    public Task changeTitle(String title) {
        if (StringUtils.isNotBlank(title)) {
            return new Task(this.id, title, this.description);
        }
        return this;
    }
}
