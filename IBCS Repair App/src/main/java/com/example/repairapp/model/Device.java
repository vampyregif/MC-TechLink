package com.example.repairapp.model;

import com.example.repairapp.model.BillingInfo;

public class Device {
    private String deviceId; // Maps to Device_ID
    private String devStatus; // Maps to Dev_Status
    private BillingInfo devBilling; // Maps to Dev_Billing object

    public Device() {}

    public Device(String deviceId, String devStatus, BillingInfo devBilling) {
        this.deviceId = deviceId;
        this.devStatus = devStatus;
        this.devBilling = devBilling;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getDevStatus() {
        return devStatus;
    }
    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }
    public BillingInfo getDevBilling() {
        return devBilling;
    }
    public void setDevBilling(BillingInfo devBilling) {
        this.devBilling = devBilling;
    }
}
