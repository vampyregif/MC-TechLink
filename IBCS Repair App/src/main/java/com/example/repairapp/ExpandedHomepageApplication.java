package com.example.repairapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;

public class ExpandedHomepageApplication {
    private StackPane centerEH;
    private Group groupOrganizer;

    public void start(Stage stage) throws Exception {
        FirebaseInitializer.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(ExpandedHomepageApplication.class.getResource("ExpandedHomepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}
