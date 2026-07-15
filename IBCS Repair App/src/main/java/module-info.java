module com.example.repairapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires com.google.auth.oauth2;
    requires firebase.admin;
    requires com.google.auth;
    requires google.cloud.firestore;
    requires google.cloud.core;
    requires java.net.http;
    requires javafx.graphics;

    opens com.example.repairapp.controller to javafx.fxml;
    opens com.example.repairapp.model to firebase.admin, javafx.fxml;

    exports com.example.repairapp;
    exports com.example.repairapp.model;
    exports com.example.repairapp.controller;
    exports com.example.repairapp.database;
    exports com.example.repairapp.utility;

}