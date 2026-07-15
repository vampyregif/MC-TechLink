package com.example.repairapp.model;

public class BillingInfo {
    private boolean isPutInPS;
    private boolean isPaid;

    public BillingInfo() {}

    public BillingInfo(boolean isPutInPS, boolean isPaid) {
        this.isPutInPS = isPutInPS;
        this.isPaid = isPaid;
    }
    public boolean isPutInPS() {
        return isPutInPS;
    }
    public void setPutInPS(boolean isPutInPS) {
        this.isPutInPS = isPutInPS;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}