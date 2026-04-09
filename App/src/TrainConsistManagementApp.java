import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainConsistManagementApp {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo, List<String> logs) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                logs.add("Cargo assigned successfully -> " + cargo + " (for " + shape + ")");
            } catch (CargoSafetyException e) {
                logs.add("Error: " + e.getMessage() + " (for " + shape + ")");
            } finally {
                logs.add("Cargo validation completed for " + shape + " bogie");
            }
        }

        @Override
        public String toString() {
            return shape + " -> " + (cargo == null ? "No cargo" : cargo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GoodsBogie> bogies = new ArrayList<>();
        List<String> logs = new ArrayList<>();

        System.out.println("=======================================");
        System.out.println(" UC15 - Safe Cargo Assignment Using try-catch-finally ");
        System.out.println("=======================================\n");

        System.out.print("How many goods bogies do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter bogie shape (e.g., Cylindrical, Rectangular): ");
            String shape = scanner.nextLine();
            GoodsBogie bogie = new GoodsBogie(shape);

            System.out.print("Enter cargo to assign: ");
            String cargo = scanner.nextLine();
            bogie.assignCargo(cargo, logs);

            bogies.add(bogie);
        }

        System.out.println("\nAssignment Log:");
        logs.forEach(System.out::println);

        System.out.println("\nFinal Train Consist:");
        bogies.forEach(System.out::println);

        System.out.println("\nUC15 runtime handling completed ...");
        scanner.close();
    }
}
