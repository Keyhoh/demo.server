package com.example.demo.server.domain.model.task;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class TaskSetTest {
    @Test
    void empty() {
        Set<TaskPOJO> actual = TaskPOJO.from(TaskSet.empty());
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    void put() {
        TaskSet tasks = TaskSet.empty();

        tasks = tasks.put(Task.prototype());

        Set<TaskPOJO> actual = TaskPOJO.from(tasks);
        Assertions.assertThat(actual).size().isEqualTo(1);
    }

    @Test
    void put_another() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();
        tasks = tasks.put(task);
        {
            tasks = tasks.put(TaskPOJO.from(task).build());

            Set<TaskPOJO> actual = TaskPOJO.from(tasks);
            Assertions.assertThat(actual).size().isEqualTo(1);
        }
    }

    @Test
    void put_twice() {
        TaskSet tasks = TaskSet.empty();

        tasks = tasks.put(Task.prototype());
        tasks = tasks.put(Task.prototype());

        Set<TaskPOJO> actual = TaskPOJO.from(tasks);
        Assertions.assertThat(actual).hasSize(2);
    }

    @Test
    void put_the_same() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();

        tasks = tasks.put(task).put(task);

        Set<TaskPOJO> actual = TaskPOJO.from(tasks);
        Assertions.assertThat(actual).hasSize(1);
    }

    @Test
    void remove() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();
        {
            tasks = tasks.put(task);

            Set<TaskPOJO> actual = TaskPOJO.from(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
        {
            tasks = tasks.remove(task);

            Set<TaskPOJO> actual = TaskPOJO.from(tasks);
            Assertions.assertThat(actual).isEmpty();
        }
    }

    @Test
    void remove_another() {
        TaskSet tasks = TaskSet.empty();
        Task task = Task.prototype();
        tasks = tasks.put(task);

        tasks = tasks.remove(TaskPOJO.from(task).build());

        Set<TaskPOJO> actual = TaskPOJO.from(tasks);
        Assertions.assertThat(actual).isEmpty();
    }

    @Test
    void remove_the_other() {
        TaskSet tasks = TaskSet.empty();
        {
            tasks = tasks.put(Task.prototype());

            Set<TaskPOJO> actual = TaskPOJO.from(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
        {
            tasks = tasks.remove(Task.prototype());

            Set<TaskPOJO> actual = TaskPOJO.from(tasks);
            Assertions.assertThat(actual).isNotEmpty();
        }
    }
}