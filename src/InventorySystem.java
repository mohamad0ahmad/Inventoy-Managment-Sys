import java.util.*;

public class InventorySystem {
    private final Map<String, Product> inventory;
    private final Queue<String> orderQueue;
    private final Stack<String> completedOrders;

    public InventorySystem() {
        inventory = new HashMap<>();
        orderQueue = new LinkedList<>();
        completedOrders = new Stack<>();
    }


    public void addOrUpdateStock(String item, int quantity) {
        item = item.trim();
            if (quantity < 0) {
                System.out.println("Quantity must be a positive number.");
                return;
            }
        if (inventory.containsKey(item)) {
            Product product = inventory.get(item);
            int oldQuantity = product.getQuantity();
            product.addStock(quantity);
            System.out.println("Updated stock for " + item + ": " + oldQuantity + " -> " + product.getQuantity());
        } else {
            inventory.put(item, new Product(item, quantity));
            System.out.println(quantity + " units of " + item + " added to inventory.");
        }
    }



    public void placeOrder(String item, String quantityStr) {

        item = item.trim();
        int quantity;
            quantity = Integer.parseInt(quantityStr);
            if (quantity < 0) {
                System.out.println("Quantity must be a positive number.");
                return;
            }
        if (inventory.containsKey(item)) {
            Product product = inventory.get(item);
            if (product.getQuantity() >= quantity) {
                product.reduceStock(quantity);
                System.out.println("Order processed: " + quantity + " units of " + item);
            } else {
                orderQueue.add(item + ":" + quantity);
                System.out.println("Order queued: " + quantity + " units of " + item);
            }
        } else {
            System.out.println("Item not found in inventory.");
        }

    }


    public void processPendingOrders() {
        System.out.println("\nProcessing Pending Orders...");


        int size = orderQueue.size();
        for (int i = 0; i < size; i++) {
            String order = orderQueue.poll();
            String[] parts = order.split(":");
            String item = parts[0];
            int quantity = Integer.parseInt(parts[1]);


            if (inventory.containsKey(item)) {
                Product product = inventory.get(item);
                if (product.getQuantity() >= quantity) {
                    product.reduceStock(quantity);
                    System.out.println("Order fulfilled: " + quantity + " units of " + item);
                    completedOrders.push(order);
                } else {
                    System.out.println("Order still pending: " + item + " (" + quantity + " units)");
                    orderQueue.add(order);
                }
            }
        }
    }


    public void generateReports() {
        System.out.println("\n--- Inventory Report ---");
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getQuantity() + " units");
        }

        System.out.println("\n--- Pending Orders ---");
        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            for (String order : orderQueue) {
                System.out.println(order);
            }
        }
    }


    public void deleteItem(String item) {
        item = item.trim();
        if (inventory.containsKey(item)) {
            inventory.remove(item);
            System.out.println("Item '" + item + "' removed from inventory.");
        } else {
            System.out.println("Item '" + item + "' not found in inventory.");
        }
    }


    public void showCompletedOrders() {
        System.out.println("\n--- Completed Orders History ---");
        if (completedOrders.isEmpty()) {
            System.out.println("No completed orders yet.");
        } else {
            for (String order : completedOrders) {
                System.out.println(order);
            }
        }
    }
}
