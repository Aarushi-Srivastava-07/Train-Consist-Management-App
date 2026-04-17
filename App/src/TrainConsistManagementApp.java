/**
 * MAIN CLASS - TrainConsistManagementApp
 * Use Case 18: Linear Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using a simple Linear Search algorithm.
 *
 * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Accepts a search key
 * - Traverses array sequentially
 * - Stops when match is found
 * - Displays search result
 *
 * This maps basic searching logic using sequential traversal.
 *
 * @author Developer
 * @version 18.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=========================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println(); 

        boolean found = linearSearch(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.\n");
        } else {
            System.out.println("Bogie " + searchId + " not found in train consist.\n");
        }

        System.out.println("UC18 search completed ...");
    }

    /**
     * Performs a linear search to find a specific bogie ID in an array.
     * Separated into its own method to allow for standalone testing.
     * * @param arr The array of bogie IDs to search through.
     * @param target The bogie ID to find.
     * @return true if the ID is found, false otherwise.
     */
    public static boolean linearSearch(String[] arr, String target) {
        for (String id : arr) {
            if (id.equals(target)) {
                return true; 
            }
        }
        return false;
    }
}
