package com.example.repairapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.database.*;
import com.google.firebase.*;
import javafx.application.Application;

import java.io.FileInputStream;
import java.net.*;
import java.net.http.*;

public class FirebaseInitializer {
    static String key = "C:\\Users\\lizan\\IdeaProjects\\IBCS Repair App\\src\\main\\resources\\ib-computer-science-ia-51536-firebase-adminsdk-fbsvc-4a5fef374d.json";
    public static void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream(key);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ib-computer-science-ia-51536-default-rtdb.firebaseio.com/") // <-- Added Database URL
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase database has been connected");
            }

        } catch (Exception e) {
            System.out.println(" !!!!!! FIREBASE ERROR: !!!!!!");
            e.printStackTrace();
        }
    }

    public boolean authenticateLogin(String userID, String password) {
        String apiKey = "AIzaSyAA1TyxGIUTNovooNXz-xGPpcwNWdKtLyQ";
        String email = userID + "@students.norwalkps.org";
        String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey;
        String jsonBody = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Login Successful!");
                return true;
            } else {
                System.out.println("Login Failed.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("An error occurred during login.");
            e.printStackTrace();
            return false;
        }
    }
    /* Model for what sending data looks like
    public void sendData(){
        UserInfo info = new UserInfo("1323","1323","n3010869","TestStudent","1323@students.norwalkps.org");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("user-info").child("1323").setValue(info, new DatabaseReference.CompletionListener(){
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    System.out.println("Data could not be saved: " + error.getMessage());
                } else {
                    System.out.println("Repair data saved successfully!");
                }
            }
        });
    }

     */
}