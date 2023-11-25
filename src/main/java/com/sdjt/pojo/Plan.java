package com.sdjt.pojo;

import lombok.Data;

@Data
public class Plan {
    private int id;
    private String question;
    private String solution;
    private String reference;
    private int score;
}
