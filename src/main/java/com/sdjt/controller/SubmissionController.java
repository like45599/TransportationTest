package com.sdjt.controller;


import com.sdjt.pojo.CompleteSubmissionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmissionController {

    @PostMapping("/submit")
    public ResponseEntity<String> submitAllData(@RequestBody CompleteSubmissionDTO submissionDTO) {
        // 处理接收到的所有数据
        // ...您的逻辑代码...

        return ResponseEntity.ok("数据已成功提交并处理");
    }
}