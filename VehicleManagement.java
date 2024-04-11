import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagement {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner key = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details:");
            System.out.println("3. Delete a vehicle:");
            System.out.println("4. Sort a vehicle list by age:");
            System.out.println("5. Quit:");
            System.out.print("Enter your choice: ");
            choice = key.nextInt();
            key.nextLine();

            switch (choice) {
                case 1:
                    addVehicle(vehicleList, key);
                    break;
                case 2:
                    displayVehicles(vehicleList);
                    break;
                case 3:
                    deleteVehicle(vehicleList, key);
                    break;
                case 4:
                    sortVehicles(vehicleList, key);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        key.close();
    }

    public static void addVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
        System.out.print("Enter registration number: ");
        String regNo = key.nextLine();
        System.out.print("Enter make: ");
        String make = key.nextLine();
        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = key.nextInt();
        System.out.print("Enter value: ");
        double value = key.nextDouble();
        key.nextLine();

        Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
        vehicleList.add(vehicle);
        System.out.println("Vehicle added successfully!\n");
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to display.");
            return;
        }

        System.out.println("Vehicle Details:");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle + "\n");
        }
    }

    public static void deleteVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to delete.");
            return;
        }

        System.out.println("Select the vehicle to delete: ");
        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println((i + 1) + ". " + vehicleList.get(i));
        }

        System.out.print("Enter the vehicle index to delete: ");
        int indexDelete = key.nextInt();
        key.nextLine();

        if (indexDelete < 1 || indexDelete > vehicleList.size()) {
            System.out.println("Invalid index. Please enter a valid index.");
            return;
        }

        vehicleList.remove(indexDelete - 1);
        System.out.println("Vehicle deleted successfully!");
    }

    public static void sortVehicles(ArrayList<Vehicle> vehicleList, Scanner key) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles to sort.");
            return;
        }

        int choice;

        do {
            System.out.println("Sort Menu:");
            System.out.println("1. Sort by age (Ascending)");
            System.out.println("2. Sort by age (Descending)");
            System.out.println("3. Main Menu");
            System.out.println("Select an option: ");
            choice = key.nextInt();
            key.nextLine();

            switch (choice) {
                case 1:
                    vehicleList.sort((v1, v2) -> Integer.compare(v1.calculateAge(2024), v2.calculateAge(2024)));
                    System.out.println("Vehicles sorted in ascending order.");
                    displayVehicles(vehicleList);
                    break;
                case 2:
                    vehicleList.sort((v1, v2) -> Integer.compare(v2.calculateAge(2024), v1.calculateAge(2024)));
                    System.out.println("Vehicles sorted in descending order.");
                    displayVehicles(vehicleList);
                    break;
                case 3:
                    System.out.println("Going back to main menu.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }
}
