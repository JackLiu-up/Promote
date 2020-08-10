package com.forlost.zhongtuo.bean;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;  //任务标题
    private String level;  //任务等级
    private String type;   //任务种类
    private int finishCount; //完成数
    private int elseCount;   //剩余数
    private double money;    //佣金
    private String imagePath; //图标路径

    public Task(String title, String level, String type, int finishCount, int elseCount, double money, String imagePath) {
        this.title = title;
        this.level = level;
        this.type = type;
        this.finishCount = finishCount;
        this.elseCount = elseCount;
        this.money = money;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", finishCount=" + finishCount +
                ", elseCount=" + elseCount +
                ", money=" + money +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(int finishCount) {
        this.finishCount = finishCount;
    }

    public int getElseCount() {
        return elseCount;
    }

    public void setElseCount(int elseCount) {
        this.elseCount = elseCount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
