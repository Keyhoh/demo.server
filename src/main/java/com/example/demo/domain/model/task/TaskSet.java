package com.example.demo.domain.model.task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TaskSet {
    private Map<TaskId, Task> values;

    private TaskSet(Map<TaskId, Task> values) {
        this.values = Collections.unmodifiableMap(values);
    }

    public static TaskSet empty() {
        return new TaskSet(Collections.emptyMap());
    }

    public TaskSet put(Task task) {
        Map<TaskId, Task> values = new HashMap<>(this.values);
        values.put(task.id, task);
        return new TaskSet(values);
    }
}
