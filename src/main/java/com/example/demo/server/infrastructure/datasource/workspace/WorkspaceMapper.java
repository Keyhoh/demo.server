package com.example.demo.server.infrastructure.datasource.workspace;

import com.example.demo.server.domain.model.workspace.WorkspacePOJO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkspaceMapper {
    void insertWorkspace(@Param("workspace") WorkspacePOJO workspace);

    WorkspacePOJO selectWorkspace(@Param("id") String id);
}
