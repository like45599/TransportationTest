package com.sdjt.service.impl;


import com.sdjt.mapper.PlanMapper;
import com.sdjt.mapper.SelectedSolutionMapper;
import com.sdjt.pojo.Plan;
import com.sdjt.service.JiebaSegmenterService;
import com.sdjt.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanMapper planMapper;
    private final JiebaSegmenterService jiebaSegmenterService;

    private final SelectedSolutionMapper selectedSolutionMapper;

    @Autowired
    public PlanServiceImpl(PlanMapper planMapper, JiebaSegmenterService jiebaSegmenterService, SelectedSolutionMapper selectedSolutionMapper) {
        this.planMapper = planMapper;
        this.jiebaSegmenterService = jiebaSegmenterService;
        this.selectedSolutionMapper = selectedSolutionMapper;
    }

    @Override
    public List<Plan> processQuestion(String question) {
        List<String> keywords = jiebaSegmenterService.segmentSentence(question);
        List<Plan> plans = planMapper.findPlansByKeywords(keywords);

        // 对 plans 进行评分和排序
        for (Plan plan : plans) {
            int score = calculateScore(plan, keywords);
            plan.setScore(score);
        }
        plans.sort(Comparator.comparingInt(Plan::getScore).reversed());

        return plans;
    }

    @Override
    public boolean saveSelectedPlans(List<Plan> selectedPlans) {
        try {
            for (Plan plan : selectedPlans) {
                selectedSolutionMapper.insertSolution(plan);
            }
            return true;
        } catch (Exception e) {
            // Log the exception
            return false;
        }

    }


    private int calculateScore(Plan plan, List<String> keywords) {
        int score = 0;
        int keywordMatchCount = countKeywordMatches(plan, keywords);
        score += keywordMatchCount;

        // 赋予匹配位置的加权
        int titleMatchCount = countTitleKeywordMatches(plan, keywords);
        score += titleMatchCount * 2; // 标题中的关键字加权更高

        return score;
    }

    private int countKeywordMatches(Plan plan, List<String> keywords) {
        int count = 0;
        String planText = plan.getQuestion() + " " + plan.getSolution() + " " + plan.getReference();
        for (String keyword : keywords) {
            if (planText.contains(keyword)) {
                count++;
            }
        }
        return count;
    }

    private int countTitleKeywordMatches(Plan plan, List<String> keywords) {
        int count = 0;
        String title = plan.getQuestion();
        for (String keyword : keywords) {
            if (title.contains(keyword)) {
                count++;
            }
        }
        return count;
    }
}