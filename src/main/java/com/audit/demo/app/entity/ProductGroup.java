package com.audit.demo.app.entity;
import java.util.List;
public class ProductGroup {
    private int pgNumber;
    private String pgName;
    List<Audit> audits;
    public ProductGroup(int pgNumber, String pgName, List<Audit> audits) {
        this.pgNumber = pgNumber;
        this.pgName = pgName;
        this.audits = audits;
    }
    public int getPgNumber() {
        return pgNumber;
    }
    public void setPgNumber(int pgNumber) {
        this.pgNumber = pgNumber;
    }
    public String getPgName() {
        return pgName;
    }
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }
    public List<Audit> getAudits() {
        return audits;
    }
    public void setAudits(List<Audit> audits) {
        this.audits = audits;
    }
    @Override
    public String toString() {
        return "ProductGroup{" +
                "pgNumber=" + pgNumber +
                ", pgName='" + pgName + '\'' +
                ", articles=" + audits +
                '}';
    }
}
