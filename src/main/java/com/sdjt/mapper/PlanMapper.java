package com.sdjt.mapper;
import com.sdjt.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PlanMapper {
    List<Plan> findPlansByKeywords(@Param("keywords") List<String> keywords);
}
