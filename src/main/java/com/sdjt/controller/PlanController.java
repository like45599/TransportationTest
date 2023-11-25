//package com.sdjt.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.huaban.analysis.jieba.JiebaSegmenter;
//import com.huaban.analysis.jieba.WordDictionary;
//import com.sdjt.pojo.Plan;
//import com.sdjt.service.PlanService;
//import com.sdjt.vo.SubmitData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.io.PrintWriter;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Comparator;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class PlanController {
//
//    private final PlanService planService;
//
//    @Autowired
//    public PlanController(PlanService planService) {
//        this.planService = planService;
//    }
//
//    @PostMapping("/submit")
//    public List<Plan> submit(@RequestBody SubmitData submitData) {
//        // 提取请求数据
////        System.out.println(submitData);
//
//        String text = submitData.getQuestion();
//
//        // jieba分词逻辑
//        /** 处理文本信息 **/
//        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
//        File file = new File("static/jieba/dict.txt");
//        Path path = Paths.get(String.valueOf(file));
//        WordDictionary.getInstance().loadUserDict(path);
//        List<String> keywords = jiebaSegmenter.sentenceProcess(text);
////        System.out.println("添加字典后：" + keywords);
//
//        /** 关键词查询 **/
////        System.out.println(planService.findAll());
//        List<Plan> matchingPlans = planService.findPlansByKeywords(keywords);
////        System.out.println(matchingPlans);
//
//        // 查询结果加权输出
//        for (Plan plan : matchingPlans) {
//            int score = calculateScore(plan, keywords);
//            plan.setScore(score);
//        }
//
//        matchingPlans.sort(Comparator.comparingInt(Plan::getScore).reversed());
////        System.out.println(matchingPlans);
//
//        return matchingPlans;
//    }
//
//    //简化版的 自定义的得分计算方法
//    private int calculateScore(Plan plan, List<String> keywords) {
//        int score = 0;
//        int keywordMatchCount = countKeywordMatches(plan, keywords);
//        score += keywordMatchCount;
//
//        // 赋予匹配位置的加权
//        int titleMatchCount = countTitleKeywordMatches(plan, keywords);
//        score += titleMatchCount * 2; // 假设标题中的关键字加权更高
//
//        return score;
//    }
//    // 计算匹配关键字数量
//    private int countKeywordMatches(Plan plan, List<String> keywords) {
//        int count = 0;
//        String planText = plan.getQuestion() + " " + plan.getSolution() + " " + plan.getReference();
//        for (String keyword : keywords) {
//            if (planText.contains(keyword)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    // 计算标题中匹配关键字的数量
//    private int countTitleKeywordMatches(Plan plan, List<String> keywords) {
//        int count = 0;
//        String title = plan.getQuestion();
//        for (String keyword : keywords) {
//            if (title.contains(keyword)) {
//                count++;
//            }
//        }
//        return count;
//    }
//}