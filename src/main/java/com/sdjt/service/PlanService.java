package com.sdjt.service;

import com.sdjt.pojo.Plan;
import com.sdjt.pojo.SelectedSolution;

import java.util.List;

public interface PlanService {
    List<Plan> processQuestion(String question);

    boolean saveSelectedPlans(List<Plan> selectedPlans);
}
