package com.example.demo.domain.model;

import com.example.demo.domain.model.task.Task;

import java.util.ArrayList;
import java.util.List;

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
    List<Task> tasks;

    Workspace(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }
}
