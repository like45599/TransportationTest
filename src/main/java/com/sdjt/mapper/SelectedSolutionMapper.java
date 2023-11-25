package com.sdjt.mapper;

import com.sdjt.pojo.Plan;
import com.sdjt.pojo.SelectedSolution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface SelectedSolutionMapper {

//    @Insert("INSERT INTO selected_solutions (question, solution, reference, project_id) VALUES (#{question}, #{solution}, #{reference}, #{projectId})")
    int insertSolution(Plan plan);
}