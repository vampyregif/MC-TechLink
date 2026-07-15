package com.example.repairapp.model;

import java.util.List;

public class Repair {
    private String rhId; // Maps to RH_ID
    private String devProb; // Maps to Dev_Prob
    private String dateReceived; // Maps to Date_Received
    private String dateResolved; // Maps to Date_Resolved (null if still active)
    private String devStatus; // Maps to Dev_Status (e.g., "In Progress", "Completed")
    private boolean repPriority; // Maps to Rep_Priority
    private String repUpdates; // Maps to Rep_Updates
    private List<DeviceStatus> statusHistory;

    public Repair() {}

    public Repair(String rhId, String devProb, String dateReceived, String dateResolved,
                  String devStatus, boolean repPriority, String repUpdates, List<DeviceStatus> statusHistory) {
        this.rhId = rhId;
        this.devProb = devProb;
        this.dateReceived = dateReceived;
        this.dateResolved = dateResolved;
        this.devStatus = devStatus;
        this.repPriority = repPriority;
        this.repUpdates = repUpdates;
        this.statusHistory = statusHistory;
    }
    public String getRhId() {
        return rhId;
    }
    public String getDevProb() {
        return devProb;
    }
    public void setDevProb(String devProb) {
        this.devProb = devProb;
    }
    public String getDateReceived() {
        return dateReceived;
    }
    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }
    public String getDateResolved() {
        return dateResolved;
    }
    public void setDateResolved(String dateResolved) {
        this.dateResolved = dateResolved;
    }
    public String getDevStatus() {
        return devStatus;
    }
    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }
    public boolean isRepPriority() {
        return repPriority;
    }
    public void setRepPriority(boolean repPriority) {
        this.repPriority = repPriority;
    }
    public String getRepUpdates() {
        return repUpdates;
    }
    public void setRepUpdates(String repUpdates) {
        this.repUpdates = repUpdates;
    }
    public List<DeviceStatus> getStatusHistory() { return statusHistory; }

    public void setStatusHistory(List<DeviceStatus> statusHistory) { this.statusHistory = statusHistory; }

}
