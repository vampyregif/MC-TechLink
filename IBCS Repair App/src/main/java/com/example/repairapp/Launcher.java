package com.example.repairapp;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        FirebaseInitializer.initialize();
        Application.launch(LoginPageApplication.class, args);
    }
}
