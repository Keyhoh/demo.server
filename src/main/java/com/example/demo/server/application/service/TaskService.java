package com.example.demo.server.application.service;

import com.example.demo.server.application.repository.TaskRepository;
import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskId;
import com.example.demo.server.domain.model.task.TaskSet;
import com.example.demo.server.domain.model.workspace.Workspace;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * タスクを取得する
     *
     * @param id タスクID
     * @return タスク
     */
    public Task findBy(TaskId id) {
        return this.taskRepository.findBy(id);
    }

    /**
     * タスクを追加する
     *
     * @param workspace 対象ワークスペース
     * @return タスク一覧
     */
    public TaskSet add(Workspace workspace) {
        TaskSet tasks = workspace.add(Task.prototype());
        this.taskRepository.save(workspace);
        return tasks;
    }

    /**
     * タスクを削除する
     *
     * @param workspace 対象ワークスペース
     * @param task      対象タスク
     * @return タスク一覧
     */
    public TaskSet remove(Workspace workspace, Task task) {
        TaskSet tasks = workspace.remove(task);
        this.taskRepository.save(workspace);
        return tasks;
    }
}
