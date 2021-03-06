package com.example.demo.server.util;

import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskPOJO;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskUtil {
    public static TaskPOJO generate() {
        return TaskPOJO.from(Task.prototype());
    }

    public static Set<TaskPOJO> generate(int size) {
        if (size <= 0) return Collections.emptySet();

        return IntStream.range(0, size)
                .mapToObj(i -> TaskUtil.generate())
                .collect(Collectors.toSet());
    }
}
