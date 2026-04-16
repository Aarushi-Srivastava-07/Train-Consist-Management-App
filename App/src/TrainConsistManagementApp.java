/**
 * MAIN CLASS - TrainConsistManagementApp
 * Use Case 20: Defensive Programming - Throw Exception on Empty Train Consist
 * * Description:
 * This class demonstrates checking for invalid states before 
 * performing operations. If the train consist (array) is empty, 
 * it throws an IllegalStateException immediately (Fail-Fast).
 *
 * At this stage, the application:
 * - Checks if the array is null or empty
 * - Throws IllegalStateException if no bogies exist
 * - Halts the search operation explicitly and safely
 *
 * @author Developer
 * @version 20.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println(" UC20 - Defensive Search (Empty Train Handling) ");
        System.out.println("=================================================\n");

        // Scenario 1: Searching an empty train consist
        String[] emptyBogieIds = {};
        String searchId = "BG412";

        System.out.println("Scenario: Triggering search on an empty train consist...");
        
        try {
            // ---- DEFENSIVE PROGRAMMING LOGIC ----
            // This will throw an exception and jump straight to the catch block
            boolean found = searchBogieDefensively(emptyBogieIds, searchId);
            
            System.out.println("Result: " + found); // This line won't execute
        } catch (IllegalStateException e) {
            System.out.println("\n[ERROR CAUGHT] Operation Stopped Immediately.");
            System.out.println("Meaningful User Message: " + e.getMessage() + "\n");
        }

        System.out.println("UC20 defensive programming demonstration completed ...");
    }

    /**
     * Searches for a bogie ID, but enforces a defensive Fail-Fast check first.
     * Separated into its own method to allow for standalone testing.
     * * @param arr The array of bogie IDs to search through.
     * @param target The bogie ID to find.
     * @return true if the ID is found, false otherwise.
     * @throws IllegalStateException if the array is empty or null.
     */
    public static boolean searchBogieDefensively(String[] arr, String target) {
        // 1. STATE VALIDATION (Defensive Programming)
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Cannot perform search: No bogies exist in the train consist.");
        }

        // 2. SEARCH LOGIC (Only executes if validation passes)
        for (String id : arr) {
            if (id.equals(target)) {
                return true;
            }
        }
        
        return false;
    }
}