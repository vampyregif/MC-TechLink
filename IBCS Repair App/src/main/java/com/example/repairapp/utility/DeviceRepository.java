package com.example.repairapp.utility;

import com.example.repairapp.database.FirebaseConnection;
import com.example.repairapp.model.Device;
import com.example.repairapp.model.Repair;       // Added to allow repair sorting
import com.example.repairapp.model.UserInfo;     // Added to allow student processing
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;                      // Added for lists
import java.util.HashSet;                        // Added for duplicate tracking
import java.util.List;                           // Added for collections
import java.util.Map;
import java.util.Set;                            // Added for O(N) unique key tracking
import java.util.concurrent.CompletableFuture;

public class DeviceRepository {

    public static class ImportResult {
        public final List<UserInfo> cleanRecords = new ArrayList<>();
        public final List<UserInfo> flaggedDuplicates = new ArrayList<>();
    }


    public static ImportResult processAndFlagDuplicates(List<UserInfo> rawStudents) {
        ImportResult result = new ImportResult();
        Set<String> seenEmails = new HashSet<>();

        for (UserInfo student : rawStudents) {
            String email = student.getStudentEmail();
            if (email == null || email.isEmpty()) {
                continue; // Ignore completely blank rows
            }

            String standardizedEmail = email.toLowerCase().trim();

            // HashSet.add() returns false if the element already exists in the set
            if (seenEmails.add(standardizedEmail)) {
                result.cleanRecords.add(student);
            } else {
                result.flaggedDuplicates.add(student);
            }
        }
        return result;
    }

    public static void sortByDeviceProblem(List<Repair> repairs) {
        if (repairs == null || repairs.isEmpty()) {
            return;
        }

        int n = repairs.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                String prob1 = repairs.get(j).getDevProb();
                String prob2 = repairs.get(minIdx).getDevProb();

                // Safe null-handling to prevent crashes during comparisons
                if (prob1 == null) prob1 = "";
                if (prob2 == null) prob2 = "";

                // Case-insensitive alphabetical comparison
                if (prob1.compareToIgnoreCase(prob2) < 0) {
                    minIdx = j;
                }
            }

            // Swap elements in-place
            Repair temp = repairs.get(minIdx);
            repairs.set(minIdx, repairs.get(i));
            repairs.set(i, temp);
        }
    }

    private static DatabaseReference getDevicesRef(String userId) {
        return FirebaseConnection.getDb()
                .getReference()
                .child("Users")
                .child(userId)
                .child("Devices");
    }

    public static void create(String userId, Device device) {
        getDevicesRef(userId).child(device.getDeviceId()).setValueAsync(device);
    }

    public static CompletableFuture<Device> read(String userId, String deviceId) {
        CompletableFuture<Device> future = new CompletableFuture<>();
        getDevicesRef(userId).child(deviceId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    future.complete(snapshot.getValue(Device.class));
                } else {
                    future.complete(null);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                future.completeExceptionally(error.toException());
            }
        });
        return future;
    }

    public static void update(String userId, String deviceId, Map<String, Object> updates) {
        getDevicesRef(userId).child(deviceId).updateChildrenAsync(updates);
    }

    public static void delete(String userId, String deviceId) {
        getDevicesRef(userId).child(deviceId).removeValueAsync();
    }
}