package com.example.demo.domain.model.task;

/**
 * タスク
 * TODO: ステータス
 * TODO: 期限
 */
public class Task {
    /**
     * ID
     */
    TaskId id;
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
     * 基礎タスクを返却する
     *
     * @return
     */
    public static Task prototype() {
        return new Task(TaskId.random(), "", "");
    }
}
