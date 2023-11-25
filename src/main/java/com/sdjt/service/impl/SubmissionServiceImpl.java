package com.sdjt.service.impl;


import com.sdjt.pojo.CompleteSubmissionDTO;
import com.sdjt.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Override
    public void processSubmission(CompleteSubmissionDTO submissionDTO) {
        // 处理提交的数据，例如保存到数据库等操作

        // 运行 Python 脚本
        runPythonScript(submissionDTO);
    }

    private void runPythonScript(CompleteSubmissionDTO submissionDTO) {
        try {
            // 通过 ProcessBuilder 调用 Python 脚本
            ProcessBuilder processBuilder = new ProcessBuilder("python", "path/to/your/script.py");
            // 传递数据给 Python 脚本
            // 示例: 将图片路径和解决方案作为参数传递
            List<String> arguments = new ArrayList<>();
            arguments.addAll(submissionDTO.getUploadedImagePaths());
            submissionDTO.getSelectedSolutions().forEach(plan -> arguments.add(plan.getSolution()));
            processBuilder.command().addAll(arguments);

            Process process = processBuilder.start();
            // 处理脚本的输出和错误流...

        } catch (Exception e) {
            e.printStackTrace();
            // 处理异常...
        }
    }
}