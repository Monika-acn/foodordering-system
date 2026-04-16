// WHY: This class represents one food order.
// It holds all the data (order ID, customer, food item, status).
// We use an enum for status so only VALID values are allowed.

public class Order {
    private String orderId;       // Unique ID for each order
    private String customerName;
    private String foodItem;
    private String status;        // PENDING, PROCESSING, DELIVERED

    // Constructor: called when a new order is created
    public Order(String orderId, String customerName, String foodItem) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.status = "PENDING";  // Every order starts as PENDING
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public String getStatus()  { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order[" + orderId + ", " + customerName + ", " + foodItem + ", " + status + "]";
    }
}