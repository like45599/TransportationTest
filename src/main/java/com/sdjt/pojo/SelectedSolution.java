package com.sdjt.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SelectedSolution {
    private int id;
    private String question;
    private String solution;
    private String reference;
    private int project_id;          // 与项目相关的字段，用于关联图片等资源
    private LocalDateTime timestamp; // 用户选择解决方案的时间
}