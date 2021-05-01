package com.example.demo.domain.model.task;

/**
 * タスク
 */
public class Task {
    /**
     * タイトル
     */
    String title;
    /**
     * 詳細
     */
    String description;

    Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
