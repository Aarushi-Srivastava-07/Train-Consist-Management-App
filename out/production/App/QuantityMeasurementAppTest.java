import java.util.Arrays;

/**
 * Custom Test Runner for TrainConsistManagementApp Arrays.sort() logic.
 * This file runs without any external dependencies like JUnit.
 */
public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" Running Arrays.sort() Test Cases ");
        System.out.println("=========================================\n");

        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();

        System.out.println("\nAll tests execution finished.");
    }

    // --- TEST CASES ---

    static void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        TrainConsistManagementApp.sortBogies(bogies);
        checkAndPrintResult("testSort_BasicAlphabeticalSorting", expected, bogies);
    }

    static void testSort_UnsortedInput() {
        String[] bogies = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        
        TrainConsistManagementApp.sortBogies(bogies);
        checkAndPrintResult("testSort_UnsortedInput", expected, bogies);
    }

    static void testSort_AlreadySortedArray() {
        String[] bogies = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        
        TrainConsistManagementApp.sortBogies(bogies);
        checkAndPrintResult("testSort_AlreadySortedArray", expected, bogies);
    }

    static void testSort_DuplicateBogieNames() {
        String[] bogies = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        
        TrainConsistManagementApp.sortBogies(bogies);
        checkAndPrintResult("testSort_DuplicateBogieNames", expected, bogies);
    }

    static void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        String[] expected = {"Sleeper"};
        
        TrainConsistManagementApp.sortBogies(bogies);
        checkAndPrintResult("testSort_SingleElementArray", expected, bogies);
    }

    // --- HELPER METHOD TO VERIFY RESULTS ---

    /**
     * Compares the expected string array with the actual sorted string array and prints the result.
     */
    static void checkAndPrintResult(String testName, String[] expected, String[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName);
            System.out.println("   Expected: " + Arrays.toString(expected));
            System.out.println("   Actual:   " + Arrays.toString(actual));
        }
    }
}