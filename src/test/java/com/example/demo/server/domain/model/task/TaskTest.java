package com.example.demo.server.domain.model.task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {
    @Test
    void prototype() {
        TaskPOJO actual = TaskPOJO.from(Task.prototype());
        assertThat(actual.id).isNotBlank();
        assertThat(actual.title).isEmpty();
        assertThat(actual.description).isEmpty();
    }
}