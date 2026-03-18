package com.example.repairapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginPageApplication extends Application {

    @FXML
    private TextField userTextField;
    private PasswordField passTextField;
    private Group boardGroup;
    private StackPane centerBox;

    private final double BASE_WIDTH = 600.0;
    private final double BASE_HEIGHT = 400.0;

    @Override
    public void start(Stage stage) throws IOException {
        FirebaseInitializer.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPageApplication.class.getResource("Loginpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void logIn(ActionEvent event) {
        System.out.println("The button was clicked! Running logic...");

        try {
            String username = userTextField.getText().trim();
            String password = passTextField.getText().trim();

            FirebaseInitializer m = new FirebaseInitializer();
            boolean isSuccess = m.authenticateLogin(username, password);

            if (isSuccess) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpandedHomepage.fxml"));
                    Parent root = loader.load();
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    currentStage.setScene(new Scene(root));
                    currentStage.show();

                } catch (Exception ev) {
                    System.out.println("Error loading the homepage!");
                    ev.printStackTrace();
                }
            } else {
                System.out.println("Login failed.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Login Failed");
                alert.setContentText("Incorrect ID or Password. Please try again.");
                alert.show();
            }
        } catch (Exception ex) {
            System.out.println("Code crashed during login.");
            ex.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Log In Error!");
            alert.setContentText("Please make sure that the password and username fields are filled out.");
            alert.show();
        }
    }

    /*
    public void initialize() {
        javafx.beans.value.ChangeListener<Number> sizeListener = (observable, oldValue, newValue) -> {
            double scaleX = centerBox.getWidth() / BASE_WIDTH;
            double scaleY = centerBox.getHeight() / BASE_HEIGHT;
            double scale = Math.min(scaleX, scaleY);

            boardGroup.setScaleX(scale);
            boardGroup.setScaleY(scale);
        };

        centerBox.widthProperty().addListener(sizeListener);
        centerBox.heightProperty().addListener(sizeListener);
    }
    */

}