package com.example.demo.server.infrastructure.datasource.task;

import com.example.demo.server.application.repository.TaskRepository;
import com.example.demo.server.domain.model.task.Task;
import com.example.demo.server.domain.model.task.TaskId;
import com.example.demo.server.domain.model.workspace.Workspace;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDatasource implements TaskRepository {
    private final TaskMapper taskMapper;

    public TaskDatasource(final TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public Task findBy(final TaskId id) {
        return this.taskMapper.selectTask(id.toString()).build();
    }

    @Override
    public void save(final Workspace workspace) {
        WorkspacePOJO pojo = WorkspacePOJO.from(workspace);
        this.taskMapper.deleteTasks(pojo.id);
        this.taskMapper.insertTasks(pojo.id, pojo.tasks);
    }
}
