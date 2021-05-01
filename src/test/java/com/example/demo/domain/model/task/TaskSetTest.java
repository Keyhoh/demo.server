package com.example.demo.domain.model.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSetTest {
    @Test
    void empty() {
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(TaskSet.empty());
        assertThat(actual).isEmpty();
    }

    @Test
    void put() {
        TaskSet tasks = TaskSet.empty();
        tasks = tasks.put(Task.prototype());
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
        assertThat(actual).isNotEmpty();
    }
}