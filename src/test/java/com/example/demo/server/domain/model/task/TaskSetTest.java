package com.example.demo.server.domain.model.task;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSetTest {
    @Test
    void empty() {
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(TaskSet.empty());
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    void put() {
        TaskSet tasks = TaskSet.empty();
        tasks = tasks.put(Task.prototype());
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
        Assertions.assertThat(actual).isNotEmpty();
    }

    @Test
    void put_twice() {
        TaskSet tasks = TaskSet.empty();
        tasks = tasks.put(Task.prototype());
        tasks = tasks.put(Task.prototype());
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
        Assertions.assertThat(actual).hasSize(2);
    }

    @Test
    void put_the_same() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();
        tasks = tasks.put(task).put(task);
        List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
        Assertions.assertThat(actual).hasSize(1);
    }

    @Test
    void remove() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();
        {
            tasks = tasks.put(task);
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
        {
            tasks = tasks.remove(task);
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
            Assertions.assertThat(actual).isEmpty();
        }
    }

    @Test
    void remove_the_other() {
        TaskSet tasks = TaskSet.empty();
        {
            tasks = tasks.put(Task.prototype());
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
        {
            tasks = tasks.remove(Task.prototype());
            List<TaskPOJO> actual = TaskPOJO.toPOJOList(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
    }
}