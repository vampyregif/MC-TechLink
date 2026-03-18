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

    opens com.example.repairapp to javafx.fxml, firebase.admin;
    exports com.example.repairapp;

}