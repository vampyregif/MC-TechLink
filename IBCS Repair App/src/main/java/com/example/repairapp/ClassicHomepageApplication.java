package com.example.repairapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassicHomepageApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FirebaseInitializer.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(ClassicHomepageApplication.class.getResource("ClassicHomepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
