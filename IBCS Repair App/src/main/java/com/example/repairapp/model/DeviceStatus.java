package com.example.repairapp.model;

public class DeviceStatus {
    private double feeAmount;
    private boolean isEnteredIntoPowerSchool;
    private boolean isStudentEmailed;
    private boolean isFixed;
    private boolean isPickedUp;
    private String loanerAssetTag;
    private boolean isPaymentVerified;
    private boolean isMailedOut;
    private boolean isReceivedBackFromMail;
    private String statusNotes;
    private boolean isLost;

    public DeviceStatus() {}

    public DeviceStatus(double feeAmount, boolean isStudentEmailed) {
        this.feeAmount = feeAmount;
        this.isStudentEmailed = isStudentEmailed;
    }

    public DeviceStatus(boolean isMailedOut, boolean isReceivedBackFromMail, String statusNotes) {
        this.isMailedOut = isMailedOut;
        this.isReceivedBackFromMail = isReceivedBackFromMail;
        this.statusNotes = statusNotes;
    }

    public DeviceStatus(boolean isFixed, boolean isPickedUp, boolean isEnteredIntoPowerSchool, String statusNotes) {
        this.isFixed = isFixed;
        this.isPickedUp = isPickedUp;
        this.isEnteredIntoPowerSchool = isEnteredIntoPowerSchool;
        this.statusNotes = statusNotes;
    }

    public double getFeeAmount() { return feeAmount; }
    public void setFeeAmount(double feeAmount) { this.feeAmount = feeAmount; }

    public boolean isEnteredIntoPowerSchool() { return isEnteredIntoPowerSchool; }
    public void setEnteredIntoPowerSchool(boolean enteredIntoPowerSchool) { isEnteredIntoPowerSchool = enteredIntoPowerSchool; }

    public boolean isStudentEmailed() { return isStudentEmailed; }
    public void setStudentEmailed(boolean studentEmailed) { isStudentEmailed = studentEmailed; }

    public boolean isFixed() { return isFixed; }
    public void setFixed(boolean fixed) { isFixed = fixed; }

    public boolean isPickedUp() { return isPickedUp; }
    public void setPickedUp(boolean pickedUp) { isPickedUp = pickedUp; }

    public String getLoanerAssetTag() { return loanerAssetTag; }
    public void setLoanerAssetTag(String loanerAssetTag) { this.loanerAssetTag = loanerAssetTag; }

    public boolean isPaymentVerified() { return isPaymentVerified; }
    public void setPaymentVerified(boolean paymentVerified) { isPaymentVerified = paymentVerified; }

    public boolean isMailedOut() { return isMailedOut; }
    public void setMailedOut(boolean mailedOut) { isMailedOut = mailedOut; }

    public boolean isReceivedBackFromMail() { return isReceivedBackFromMail; }
    public void setReceivedBackFromMail(boolean receivedBackFromMail) { isReceivedBackFromMail = receivedBackFromMail; }

    public String getStatusNotes() { return statusNotes; }
    public void setStatusNotes(String statusNotes) { this.statusNotes = statusNotes; }

    public boolean isLost() { return isLost; }
    public void setLost(boolean lost) { isLost = lost; }
}