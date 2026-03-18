package com.example.repairapp;

public class CurrentRepairInfo extends UserInfo {
    private int userid;
    private String dmgs;
    private double fees;
    private boolean resolved;
    private boolean priority;
    public CurrentRepairInfo() {
        super();
    }
    public CurrentRepairInfo(String userid, String dmgs, double fees, boolean resolved, boolean priority) {
        super(userid);
        this.dmgs = dmgs;
        this.fees = fees;
        this.resolved = resolved;
        this.priority = priority;
    }
    public String getDmgs() {
        return dmgs;
    }
    public void setDmgs(String dmgs) {
        this.dmgs = dmgs;
    }
    public double getFees() {
        return fees;
    }
    public void setFees(double fees) {
        this.fees = fees;
    }
    public boolean isResolved() {
        return resolved;
    }
    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
    public boolean isPriority() {
        return priority;
    }
    public void setPriority(boolean priority) {
        this.priority = priority;
    }

}
