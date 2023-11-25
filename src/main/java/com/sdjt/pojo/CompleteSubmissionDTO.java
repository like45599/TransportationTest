package com.sdjt.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompleteSubmissionDTO {
    private String projectName;
//    private String constructionUnit;
    // ...其他字段...
    private List<String> uploadedImagePaths;
    private List<Plan> selectedSolutions;

    // Getter 和 Setter
}