package com.sdjt.service.impl;


import com.sdjt.mapper.ProjectInfoMapper;
import com.sdjt.pojo.ProjectInfo;
import com.sdjt.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    private final ProjectInfoMapper projectInfoMapper;

    @Autowired
    public ProjectInfoServiceImpl(ProjectInfoMapper projectInfoMapper) {
        this.projectInfoMapper = projectInfoMapper;
    }

    @Override
    public ProjectInfo getProjectInfoById(int id) {
        return projectInfoMapper.findById(id);
    }

    // Implement other methods
}