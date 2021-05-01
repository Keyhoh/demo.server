package com.example.demo.server.domain.model.task;

import java.util.List;
import java.util.stream.Collectors;

/**
 * タスクPOJO
 */
public class TaskPOJO {
    public String id;
    public String title;
    public String description;

    private TaskPOJO(Task task) {
        this.id = task.id.toString();
        this.title = task.title;
        this.description = task.description;
    }

    /**
     * タスクPOJOを生成する
     *
     * @param task タスク
     * @return タスクPOJO
     */
    public static TaskPOJO toPOJO(Task task) {
        return new TaskPOJO(task);
    }

    /**
     * タスクセットPOJOを生成する
     *
     * @param taskSet タスクセット
     * @return タスクセットPOJO
     */
    public static List<TaskPOJO> toPOJOList(TaskSet taskSet) {
        return taskSet.values.values().stream().map(TaskPOJO::toPOJO).collect(Collectors.toList());
    }
}
