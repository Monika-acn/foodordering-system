// WHY: This is where execution starts. 
// It tests our logic manually before writing automated JUnit tests.

public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        // Test placing orders
        System.out.println(service.placeOrder("ORD001", "Ravi", "Biryani"));
        System.out.println(service.placeOrder("ORD002", "Priya", "Dosa"));
        
        // Test duplicate → should return ERROR
        System.out.println(service.placeOrder("ORD001", "Ravi", "Pizza"));

        // Test tracking
        System.out.println(service.trackOrder("ORD001"));
        
        // Update status
        System.out.println(service.updateStatus("ORD001", "PROCESSING"));
        System.out.println(service.updateStatus("ORD001", "DELIVERED"));
        
        // Track non-existent order
        System.out.println(service.trackOrder("ORD999"));
    }
}