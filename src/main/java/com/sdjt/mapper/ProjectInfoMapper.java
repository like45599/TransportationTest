package com.sdjt.mapper;

import com.sdjt.pojo.ProjectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProjectInfoMapper {
    @Select("SELECT * FROM project_data_table WHERE id = #{id}")
    ProjectInfo findById(@Param("id") int id);

    // Add more methods as needed
}