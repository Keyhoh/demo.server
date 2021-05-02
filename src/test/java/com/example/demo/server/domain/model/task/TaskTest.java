package com.example.demo.server.domain.model.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {
    @Test
    void prototype() {
        TaskPOJO actual = TaskPOJO.from(Task.prototype());
        assertThat(actual.id).isNotBlank();
        assertThat(actual.title).isEmpty();
        assertThat(actual.description).isEmpty();
    }

    @Test
    void change_title() {
        Task task = Task.prototype();
        task = task.changeTitle("new title");
        TaskPOJO actual = TaskPOJO.from(task);
        assertThat(actual.title).isEqualTo("new title");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ", // space
            "  ", // two spaces
            "	",  // tab
            "\t",  // tab
            "　", // full-width space
            "\n",
            "\r\n"
    })
    void cannot_change_title_to_blank(String blank) {
        Task task = Task.prototype().changeTitle("title");
        task = task.changeTitle(blank);
        TaskPOJO actual = TaskPOJO.from(task);
        assertThat(actual.title).isEqualTo("title");
    }
}