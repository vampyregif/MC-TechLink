package com.example.repairapp;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Import your reorganized files
import com.example.repairapp.model.UserInfo;
import com.example.repairapp.model.Repair;
import com.example.repairapp.utility.DeviceRepository;
import com.example.repairapp.utility.DeviceSorter;

public class LoginPageApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        runSystemTests();
    }

    /**
     * Executes internal diagnostics to verify that sorting and data deduplication
     * algorithms function perfectly with the updated model structures.
     */
    public static void runSystemTests() {
        System.out.println("==================================================");
        System.out.println("        LAUNCHING INTERNAL SYSTEM DIAGNOSTICS      ");
        System.out.println("==================================================");

        // --- DIAGNOSTIC 1: O(N) EMAIL DEDUPLICATION (using DeviceRepository) ---
        System.out.println("[DIAGNOSTIC 1] Testing Email Deduplication via DeviceRepository...");

        List<UserInfo> rawImportList = new ArrayList<>();
        rawImportList.add(new UserInfo("JD123", "John Doe", "john.doe@school.org", "11", "101A"));
        rawImportList.add(new UserInfo("JS456", "Jane Smith", "jane.smith@school.org", "12", "204B"));
        rawImportList.add(new UserInfo("JD123_DUP", "John Doe Copy", "john.doe@school.org", "11", "101A"));
        rawImportList.add(new UserInfo("JS456_DUP", "Jane Smith Alternate", " JANE.SMITH@school.org ", "12", "204B"));
        rawImportList.add(new UserInfo("JD789", "John Doe Jr.", "john.doe.jr@school.org", "9", "302C"));

        // Call the duplicate logic (re-routed to your DeviceRepository)
        DeviceRepository.ImportResult result = DeviceRepository.processAndFlagDuplicates(rawImportList);

        System.out.println("Cleaned records: " + result.cleanRecords.size() + " / Flagged duplicates: " + result.flaggedDuplicates.size());

        if (result.cleanRecords.size() == 3 && result.flaggedDuplicates.size() == 2) {
            System.out.println("✅ DIAGNOSTIC 1 SUCCESSFUL: Duplicate filtering operating correctly.");
        } else {
            System.err.println("❌ DIAGNOSTIC 1 FAILED: Mismatch in expected record sorting sizes.");
        }

        System.out.println("\n--------------------------------------------------\n");

        // --- DIAGNOSTIC 2: ALPHABETICAL REPAIR SORTING ---
        System.out.println("[DIAGNOSTIC 2] Testing Selection Sort Alphabetization...");

        List<Repair> repairs = new ArrayList<>();
        repairs.add(new Repair("RH_01", "Screen Replacement", "2026-03-01", null, "In Progress", true, "Waiting for screen", null));
        repairs.add(new Repair("RH_02", "Battery Swap", "2026-03-02", null, "In Progress", false, "Arrived", null));
        repairs.add(new Repair("RH_03", "Keyboard Keys Jammed", "2026-03-03", null, "Completed", false, "Cleaned", null));
        repairs.add(new Repair("RH_04", "Charging Port Loose", "2026-03-04", null, "In Progress", true, "Ordered port", null));

        DeviceSorter.sortByDeviceProblem(repairs);

        boolean isSorted = repairs.get(0).getDevProb().equals("Battery Swap") &&
                repairs.get(1).getDevProb().equals("Charging Port Loose") &&
                repairs.get(2).getDevProb().equals("Keyboard Keys Jammed") &&
                repairs.get(3).getDevProb().equals("Screen Replacement");

        if (isSorted) {
            System.out.println("✅ DIAGNOSTIC 2 SUCCESSFUL: Repairs accurately alphabetized.");
        } else {
            System.err.println("❌ DIAGNOSTIC 2 FAILED: Sorting algorithm did not match expected alphabetical order.");
        }
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        launch(args);
    }
}