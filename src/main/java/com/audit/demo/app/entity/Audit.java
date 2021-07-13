package com.audit.demo.app.entity;

public class Audit {
    private String branch;
    private String model;
    private String featureText;
    private String multiPack;
    private String articleNumber;
    private String pro;
    private String sal;

    public Audit(String branch, String model, String featureText, String multiPack, String articleNumber, String pro, String sal) {
        this.branch = branch;
        this.model = model;
        this.featureText = featureText;
        this.multiPack = multiPack;
        this.articleNumber = articleNumber;
        this.pro = pro;
        this.sal = sal;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFeatureText() {
        return featureText;
    }

    public void setFeatureText(String featureText) {
        this.featureText = featureText;
    }

    public String getMultiPack() {
        return multiPack;
    }

    public void setMultiPack(String multiPack) {
        this.multiPack = multiPack;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }
}
