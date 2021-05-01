package com.example.demo.domain.model.task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {
    @Test
    void prototype() {
        TaskPOJO task = new TaskPOJO(Task.prototype());
        assertThat(task.id).isNotBlank();
        assertThat(task.title).isEmpty();
        assertThat(task.description).isEmpty();
    }
}