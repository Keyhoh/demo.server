package com.example.demo.domain.model.task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * タスクセット
 */
public class TaskSet {
    private final Map<TaskId, Task> values;

    private TaskSet(Map<TaskId, Task> values) {
        this.values = Collections.unmodifiableMap(values);
    }

    /**
     * 空のタスクセットを返却する
     *
     * @return 空のタスクセット
     */
    public static TaskSet empty() {
        return new TaskSet(Collections.emptyMap());
    }

    /**
     * タスクを追加する
     *
     * @param task 追加するタスク
     * @return タスクが追加されたタスクセット
     */
    public TaskSet put(Task task) {
        Map<TaskId, Task> values = new HashMap<>(this.values);
        values.put(task.id, task);
        return new TaskSet(values);
    }
}
