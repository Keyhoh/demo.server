package com.example.demo.server.infrastructure.datasource.task;

import com.example.demo.server.domain.model.task.TaskPOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface TaskMapper {
    TaskPOJO selectTask(@Param("id") String id);

    void insertTasks(@Param("workspaceId") String workspaceId, @Param("tasks") Set<TaskPOJO> tasks);

    void deleteTasks(@Param("workspaceId") String workspaceId);
}
