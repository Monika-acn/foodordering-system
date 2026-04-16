import java.util.HashMap;
import java.util.Map;

// WHY: This is the SERVICE layer. It handles all operations on orders.
// Uses a HashMap to store orders — like a mini in-memory database.
// In real systems this would connect to MySQL/PostgreSQL.

public class OrderService {
    
    // WHY HashMap? Fast O(1) lookup by orderId. No duplicates by key.
    private Map<String, Order> orderDatabase = new HashMap<>();

    // Place a new order
    // WHY check containsKey? → Prevent DUPLICATE orders (exam requirement!)
    public String placeOrder(String orderId, String customerName, String foodItem) {
        if (orderDatabase.containsKey(orderId)) {
            return "ERROR: Order " + orderId + " already exists!"; // Duplicate prevention
        }
        Order order = new Order(orderId, customerName, foodItem);
        orderDatabase.put(orderId, order);
        return "SUCCESS: Order placed - " + order;
    }

    // Track an order by ID
    // WHY check for null? → Handle case when order doesn't exist (failure scenario)
    public String trackOrder(String orderId) {
        Order order = orderDatabase.get(orderId);
        if (order == null) {
            return "ERROR: Order not found!";
        }
        return "STATUS: " + order;
    }

    // Update order status (simulate delivery pipeline)
    public String updateStatus(String orderId, String newStatus) {
        Order order = orderDatabase.get(orderId);
        if (order == null) return "ERROR: Order not found!";
        order.setStatus(newStatus);
        return "UPDATED: " + order;
    }
}