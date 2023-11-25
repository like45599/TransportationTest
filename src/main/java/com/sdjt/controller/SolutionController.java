package com.sdjt.controller;


import com.sdjt.pojo.Plan;
import com.sdjt.pojo.SelectedSolution;
import com.sdjt.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solutions")
public class SolutionController {

    private final PlanService planService;

    @Autowired
    public SolutionController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<List<Plan>> submitQuestion(@RequestBody String question) {
        List<Plan> plans = planService.processQuestion(question);
        return ResponseEntity.ok(plans);
    }

    @PostMapping("/submitSolution")
    public ResponseEntity<String> submitSolution(@RequestBody List<Plan> plans) {

        // 假设我们仅保存选中方案的基本信息
        boolean success = planService.saveSelectedPlans(plans);

        if (success) {
            return ResponseEntity.ok("解决方案已成功保存，待生成文档");
        } else {
            return ResponseEntity.status(500).body("保存解决方案时发生错误");
        }
    }
}
