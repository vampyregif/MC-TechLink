package com.example.repairapp.database;

import com.example.repairapp.model.UserInfo;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;

public class FirebaseConnection {
    public static void initialize(String serviceAccountPath) throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            FileInputStream serviceAccount = new FileInputStream("IBCS Repair App/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ib-computer-science-ia-51536-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println(">>> Connected to Firebase Realtime Database Successfully! <<<");
        }else{

        }
    }

    public static FirebaseDatabase getDb() {
        return FirebaseDatabase.getInstance();
    }
}