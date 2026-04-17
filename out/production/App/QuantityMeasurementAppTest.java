import java.util.Arrays;

/**
 * Custom Test Runner for TrainConsistManagementApp Binary Search logic.
 * This file runs without any external dependencies like JUnit.
 */
public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" Running Binary Search Test Cases ");
        System.out.println("=========================================\n");

        testSearch_BogieFound();
        testSearch_BogieNotFound();
        testSearch_FirstElementMatch();
        testSearch_LastElementMatch();
        testSearch_SingleElementArray();

        System.out.println("\nAll tests execution finished.");
    }

    static void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearch(bogieIds, "BG309");
        checkAndPrintResult("testSearch_BogieFound", true, result);
    }

    static void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearch(bogieIds, "BG999");
        checkAndPrintResult("testSearch_BogieNotFound", false, result);
    }

    static void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearch(bogieIds, "BG101");
        checkAndPrintResult("testSearch_FirstElementMatch", true, result);
    }

    static void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearch(bogieIds, "BG550");
        checkAndPrintResult("testSearch_LastElementMatch", true, result);
    }

    static void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        boolean result = TrainConsistManagementApp.binarySearch(bogieIds, "BG101");
        checkAndPrintResult("testSearch_SingleElementArray", true, result);
    }


    
     * Compares the expected boolean result with the actual result and prints the status.
     */
    static void checkAndPrintResult(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(" PASS: " + testName);
        } else {
            System.out.println(" FAIL: " + testName);
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual:   " + actual);
        }
    }
}
