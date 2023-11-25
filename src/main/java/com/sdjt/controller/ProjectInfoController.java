package com.sdjt.controller;

import com.sdjt.pojo.ProjectInfo;
import com.sdjt.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectInfoController {

    private ProjectInfoService projectInfoService;

    @Autowired
    public ProjectInfoController(ProjectInfoService projectInfoService) {
        this.projectInfoService = projectInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectInfo> getProjectById(@PathVariable int id) {
        ProjectInfo projectInfo = projectInfoService.getProjectInfoById(id);
        return ResponseEntity.ok(projectInfo);
    }

    // Add more endpoints as needed
}