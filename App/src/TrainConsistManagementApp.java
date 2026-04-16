import java.util.Arrays;

/**
 * MAIN CLASS - TrainConsistManagementApp
 * Use Case 19: Binary Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * efficiently using the Binary Search algorithm on sorted data.
 *
 * At this stage, the application:
 * - Creates a sorted array of bogie IDs
 * - Accepts a search key
 * - Implements a divide-and-conquer strategy
 * - Uses compareTo() for string comparison
 * - Halves the search range until the target is found or exhausted
 * - Displays the search result
 *
 * @author Developer
 * @version 19.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=========================================\n");

        // Create a PRE-SORTED array of bogie IDs (Binary search requires sorted data)
        String[] sortedBogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Bogie ID to search
        String searchId = "BG412";

        // Display all bogies
        System.out.println("Available Sorted Bogie IDs:");
        System.out.println(Arrays.toString(sortedBogieIds) + "\n");

        // ---- BINARY SEARCH LOGIC ----
        boolean found = binarySearch(sortedBogieIds, searchId);

        // Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.\n");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.\n");
        }

        System.out.println("UC19 search completed ...");
    }

    /**
     * Performs a binary search to find a specific bogie ID in a sorted array.
     * Separated into its own method to allow for standalone testing.
     * * @param arr The sorted array of bogie IDs to search through.
     * @param target The bogie ID to find.
     * @return true if the ID is found, false otherwise.
     */
    public static boolean binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Find the middle index safely to avoid integer overflow
            int mid = low + (high - low) / 2;

            // Compare key with mid element
            int comparisonResult = target.compareTo(arr[mid]);

            if (comparisonResult == 0) {
                return true; // Target found at mid
            } 
            else if (comparisonResult > 0) {
                // Target is lexicographically greater, ignore left half
                low = mid + 1;
            } 
            else {
                // Target is lexicographically smaller, ignore right half
                high = mid - 1;
            }
        }
        
        return false; // Range exhausted, target not found
    }
}