import java.util.Arrays;

/**
 * MAIN CLASS - TrainConsistManagementApp
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java's built-in Arrays.sort() method.
 *
 * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 * * This maps optimized sorting using Java Library utilities.
 * * @author Developer
 * @version 17.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("===============================================\n");

        // Create an array of bogie type names
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Display original order
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogies) + "\n");

        // ---- BUILT-IN SORT LOGIC ----
        sortBogies(bogies);

        // Display sorted result
        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogies) + "\n");
        
        System.out.println("UC17 sorting completed ...");
    }

    /**
     * Sorts an array of Strings in alphabetical order using Java's built-in Arrays.sort().
     * Separated into its own method to allow for unit testing.
     * * @param arr The array of bogie names to sort.
     */
    public static void sortBogies(String[] arr) {
        Arrays.sort(arr);
    }
}