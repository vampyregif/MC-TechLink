package com.example.repairapp.utility;

import com.example.repairapp.model.Device;
import com.example.repairapp.model.Repair;
import com.example.repairapp.model.UserInfo;

import java.util.List;

public class DeviceSorter {

    public static void sortByRepairType(List<Repair> repairs) {
        int n = repairs.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                String type1 = repairs.get(j).getDevProb();
                String type2 = repairs.get(minIdx).getDevProb();

                if (type1 == null) type1 = "";
                if (type2 == null) type2 = "";

                if (type1.compareToIgnoreCase(type2) < 0) {
                    minIdx = j;
                }
            }
            Repair temp = repairs.get(minIdx);
            repairs.set(minIdx, repairs.get(i));
            repairs.set(i, temp);
        }
    }

    public static void sortByStudentName(List<UserInfo> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                String name1 = students.get(j).getUserName();
                String name2 = students.get(minIdx).getUserName();

                if (name1 == null) name1 = "";
                if (name2 == null) name2 = "";

                if (name1.compareToIgnoreCase(name2) < 0) {
                    minIdx = j;
                }
            }
            UserInfo temp = students.get(minIdx);
            students.set(minIdx, students.get(i));
            students.set(i, temp);
        }
    }

    public static void sortByStatus(List<Device> devices) {
        int n = devices.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                int priority1 = getStatusPriority(devices.get(j).getDevStatus());
                int priority2 = getStatusPriority(devices.get(minIdx).getDevStatus());
                if (priority1 < priority2) {
                    minIdx = j;
                }
            }
            Device temp = devices.get(minIdx);
            devices.set(minIdx, devices.get(i));
            devices.set(i, temp);
        }
    }

    private static int getStatusPriority(String status) {
        if (status == null) return 4;
        switch (status.toLowerCase().trim()) {
            case "not started": return 1;
            case "in progress": return 2;
            case "student emailed": return 3;
            default: return 4;
        }
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

                // Safe null-handling to avoid NullPointerExceptions
                if (prob1 == null) prob1 = "";
                if (prob2 == null) prob2 = "";

                // Case-insensitive alphabetical comparison
                if (prob1.compareToIgnoreCase(prob2) < 0) {
                    minIdx = j;
                }
            }

            // Swap the positions of the two Repair objects in the list
            Repair temp = repairs.get(minIdx);
            repairs.set(minIdx, repairs.get(i));
            repairs.set(i, temp);
        }
    }
}