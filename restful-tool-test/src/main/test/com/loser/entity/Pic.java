/**
 * Copyright 2024 json.cn
 */
package com.loser.entity;

import java.util.List;

public class Pic {

    private double score;
    private String root;
    private List<String> baike_info;
    private String name;

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    public void setBaike_info(List<String> baike_info) {
        this.baike_info = baike_info;
    }

    public List<String> getBaike_info() {
        return baike_info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}