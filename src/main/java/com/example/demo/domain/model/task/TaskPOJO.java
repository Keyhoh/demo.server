package com.example.demo.domain.model.task;

/**
 * タスクPOJO
 */
public class TaskPOJO {
    public String id;
    public String title;
    public String description;

    public TaskPOJO(Task task) {
        this.id = task.id.toString();
        this.title = task.title;
        this.description = task.description;
    }
}
