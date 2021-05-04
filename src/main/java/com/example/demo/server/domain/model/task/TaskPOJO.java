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

    private TaskPOJO(Task task) {
        this.id = task.id.toString();
        this.title = task.title;
        this.description = task.description;
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
    public static List<TaskPOJO> from(TaskSet taskSet) {
        return taskSet.values.values().stream().map(TaskPOJO::from).collect(Collectors.toUnmodifiableList());
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
}
