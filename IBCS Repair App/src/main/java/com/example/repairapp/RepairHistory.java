package com.example.repairapp;

public class RepairHistory extends UserInfo{
    private String historyID;
    private String userID;
    private String pastDmgs;
    private String dateRes;
    private String pastFees;
    private String techNotes;
    public RepairHistory() {
        super();
    }
    public RepairHistory(String historyID, String userID, String dateRes, String pastFees, String techNotes) {
        this.historyID = historyID;
        super(userID);
        this.dateRes = dateRes;
        this.pastFees = pastFees;
        this.techNotes = "";
    }
    public String getPastDmgs() {
        return pastDmgs;
    }
    public void setPastDmgs(String pastDmgs) {
        this.pastDmgs = pastDmgs;
    }
    public void dateRes(String dateRes) {
        this.dateRes = dateRes;
    }
    public String getDateRes(){
        return this.dateRes;
    }
    public void setPastFees(String pastFees) {
        this.pastFees = pastFees;
    }
    public String getPastFees(){
        return this.pastFees;
    }
    public void setTechNotes(String newNotes) {
        techNotes += newNotes;
    }
    public String getTechNotes(){
        return this.techNotes;
    }
}
