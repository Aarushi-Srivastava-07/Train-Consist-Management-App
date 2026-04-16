/**
 * Custom Test Runner for TrainConsistManagementApp Defensive Programming logic.
 * This file runs without any external dependencies like JUnit.
 */
public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" Running Defensive Programming Test Cases ");
        System.out.println("=========================================\n");

        testSearch_ValidArray_ItemFound();
        testSearch_ValidArray_ItemNotFound();
        testSearch_EmptyArrayThrowsException();
        testSearch_NullArrayThrowsException();

        System.out.println("\nAll tests execution finished.");
    }

    // --- TEST CASES ---

    static void testSearch_ValidArray_ItemFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = TrainConsistManagementApp.searchBogieDefensively(bogieIds, "BG205");
        checkAndPrintResult("testSearch_ValidArray_ItemFound", true, result);
    }

    static void testSearch_ValidArray_ItemNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        boolean result = TrainConsistManagementApp.searchBogieDefensively(bogieIds, "BG999");
        checkAndPrintResult("testSearch_ValidArray_ItemNotFound", false, result);
    }

    static void testSearch_EmptyArrayThrowsException() {
        String[] emptyBogies = {};
        
        try {
            // Attempting to search an empty array
            TrainConsistManagementApp.searchBogieDefensively(emptyBogies, "BG101");
            
            // If we reach here, the exception was NOT thrown (which is a failure)
            System.out.println("❌ FAIL: testSearch_EmptyArrayThrowsException (Expected IllegalStateException, but no exception was thrown)");
        } catch (IllegalStateException e) {
            // The correct exception was thrown
            System.out.println("✅ PASS: testSearch_EmptyArrayThrowsException (Caught expected IllegalStateException)");
        } catch (Exception e) {
            // A different exception was thrown
            System.out.println("❌ FAIL: testSearch_EmptyArrayThrowsException (Expected IllegalStateException, got " + e.getClass().getSimpleName() + ")");
        }
    }

    static void testSearch_NullArrayThrowsException() {
        String[] nullBogies = null;
        
        try {
            // Attempting to search a null array
            TrainConsistManagementApp.searchBogieDefensively(nullBogies, "BG101");
            
            System.out.println("❌ FAIL: testSearch_NullArrayThrowsException (Expected IllegalStateException, but no exception was thrown)");
        } catch (IllegalStateException e) {
            System.out.println("✅ PASS: testSearch_NullArrayThrowsException (Caught expected IllegalStateException)");
        } catch (Exception e) {
            System.out.println("❌ FAIL: testSearch_NullArrayThrowsException (Expected IllegalStateException, got " + e.getClass().getSimpleName() + ")");
        }
    }

    // --- HELPER METHOD TO VERIFY STANDARD RESULTS ---

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