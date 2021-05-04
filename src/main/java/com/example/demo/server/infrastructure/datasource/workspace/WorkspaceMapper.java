package com.example.demo.server.infrastructure.datasource.workspace;

import com.example.demo.server.domain.model.task.TaskPOJO;
import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkspaceMapper {
    List<TaskPOJO> selectWorkspaceTasks(@Param("id") String id);

    void insertWorkspace(@Param("workspace") WorkspacePOJO workspace);

    WorkspacePOJO selectWorkspace(@Param("id") String id);

    void updateWorkspace(@Param("workspace") WorkspacePOJO workspacePOJO);
}
