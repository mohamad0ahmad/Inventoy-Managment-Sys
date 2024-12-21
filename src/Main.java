import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add/Update Stock");
            System.out.println("2. Place Order");
            System.out.println("3. Process Pending Orders");
            System.out.println("4. Generate Report");
            System.out.println("5. History Of Completed Orders");
            System.out.println("6. Delete Item");
            System.out.println("7. Exit");
            System.out.print("Enter your choice(1-7): ");

            // try and catch to handle the input
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String addItem = scanner.nextLine();
                        // handle empty input
                        if (addItem.isEmpty() || addItem.isBlank()) {
                            System.out.println("Item name cannot be empty!");
                            break;
                        }
                        if(containsNumber(addItem)){
                            System.out.println("Item name cannot contain numbers.");
                            break;
                        }
                        System.out.print("Enter quantity: ");
                        int addQuantity = scanner.nextInt();
                        system.addOrUpdateStock(addItem.toLowerCase(), addQuantity);
                        break;

                    case 2:
                        System.out.print("Enter item name: ");
                        String orderItem = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int orderQuantity = scanner.nextInt();
                        system.placeOrder(orderItem.toLowerCase(), orderQuantity+"");
                        break;

                    case 3:
                        system.processPendingOrders();
                        break;

                    case 4:
                        system.generateReports();
                        break;

                    case 5:
                        system.showCompletedOrders();
                        break;

                    case 6:
                        System.out.print("Enter item name to delete: ");
                        String deleteItem = scanner.nextLine();
                        system.deleteItem(deleteItem.toLowerCase());
                        break;

                    case 7:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                choice = 0; // to reuse the do_while
            }
        } while (choice != 7);

    }
    private static boolean containsNumber(String str) {
        return str.matches(".*\\d.*");
    }
}

