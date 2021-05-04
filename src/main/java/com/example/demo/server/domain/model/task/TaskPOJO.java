package com.example.demo.server.domain.model.task;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * タスクPOJO
 */
public class TaskPOJO {
    final public String id;
    final public String title;
    final public String description;

    private TaskPOJO(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    private TaskPOJO(Task task) {
        this(task.id.toString(), task.title, task.description);
    }

    /**
     * タスクPOJOを生成する
     *
     * @param task タスク
     * @return タスクPOJO
     */
    public static TaskPOJO from(Task task) {
        return new TaskPOJO(task);
    }

    /**
     * タスクセットPOJOを生成する
     *
     * @param taskSet タスクセット
     * @return タスクセットPOJO
     */
    public static Set<TaskPOJO> from(TaskSet taskSet) {
        return taskSet.values.values().stream().map(TaskPOJO::from).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * タスクを構築する
     *
     * @return タスク
     */
    public Task build() {
        return new Task(TaskId.of(this.id), this.title, this.description);
    }

    /**
     * タスクセットCollector
     */
    public static final Collector<Task, Map<TaskId, Task>, TaskSet> collector = new Collector<>() {

        @Override
        public Supplier<Map<TaskId, Task>> supplier() {
            return HashMap::new;
        }

        @Override
        public BiConsumer<Map<TaskId, Task>, Task> accumulator() {
            return (map, task) -> map.put(task.id, task);
        }

        @Override
        public BinaryOperator<Map<TaskId, Task>> combiner() {
            return (m1, m2) -> {
                for (Map.Entry<TaskId, Task> e : m2.entrySet())
                    m1.merge(e.getKey(), e.getValue(), (task1, task2) -> task2);
                return m1;
            };
        }

        @Override
        public Function<Map<TaskId, Task>, TaskSet> finisher() {
            return TaskSet::new;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
        }
    };

    @Override
    public String toString() {
        return "TaskPOJO{" +
                "id='" + this.id + '\'' +
                ", title='" + this.title + '\'' +
                ", description='" + this.description + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final TaskPOJO taskPOJO = (TaskPOJO) o;

        if (!this.id.equals(taskPOJO.id)) return false;
        if (!this.title.equals(taskPOJO.title)) return false;
        return this.description.equals(taskPOJO.description);
    }

    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.title.hashCode();
        result = 31 * result + this.description.hashCode();
        return result;
    }
}
