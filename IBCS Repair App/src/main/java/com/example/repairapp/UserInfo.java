package com.example.repairapp;

public class UserInfo {
    private String userID;
    private String username;
    private String password;
    private String studentName;
    private String email;

    public UserInfo() {
    }

    public UserInfo(String userID){
        this.userID = userID;
    }

    public UserInfo(String userID, String username, String password, String studentName, String email) {
        this.username = username;
        this.password = password;
        this.studentName = studentName;
        this.email = email;
    }
    public String getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getEmail() {
        return email;
    }
}
