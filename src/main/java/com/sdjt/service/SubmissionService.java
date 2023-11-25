package com.sdjt.service;

import com.sdjt.pojo.CompleteSubmissionDTO;

public interface SubmissionService {
    void processSubmission(CompleteSubmissionDTO submissionDTO);
}