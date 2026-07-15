package com.example.repairapp.model;

public class UserInfo {
    private String userId; // Maps to User_ID
    private String userName; // Maps to User_Name
    private String studentEmail; // Maps to Student_Email
    private String studentName; // Maps to Student_Name
    private String studentSchool; // Maps to Student_School

    // Required empty constructor for Firestore
    public UserInfo() {}

    public UserInfo(String userId, String userName, String studentEmail, String studentName, String studentSchool) {
        this.userId = userId;
        this.userName = userName;
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.studentSchool = studentSchool;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentSchool() {
        return studentSchool;
    }
    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }
}