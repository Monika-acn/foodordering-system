import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// WHY @TestMethodOrder? → Ensures tests run in a predictable order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OrderServiceTest {

    // WHY static? → Same instance shared across all test methods
    private static OrderService service;

    // WHY @BeforeAll? → Runs ONCE before all tests. Set up shared resources here.
    @BeforeAll
    static void setup() {
        service = new OrderService();
    }

    // TEST 1: Successful order placement
    @Test
    @org.junit.jupiter.api.Order(1)
    void testPlaceOrderSuccess() {
        String result = service.placeOrder("ORD001", "Ravi", "Biryani");
        // WHY assertTrue with contains? → Check the success message
        assertTrue(result.contains("SUCCESS"), "Order should be placed successfully");
    }

    // TEST 2: Duplicate order → must return ERROR
    @Test
    @org.junit.jupiter.api.Order(2)
    void testDuplicateOrderPrevention() {
        String result = service.placeOrder("ORD001", "Ravi", "Pizza"); // same ID
        assertTrue(result.contains("ERROR"), "Duplicate order should return error");
    }

    // TEST 3: Track a valid order
    @Test
    @org.junit.jupiter.api.Order(3)
    void testTrackOrderSuccess() {
        String result = service.trackOrder("ORD001");
        assertTrue(result.contains("STATUS"), "Should return order status");
    }

    // TEST 4: Track non-existent order → failure scenario
    @Test
    @org.junit.jupiter.api.Order(4)
    void testTrackOrderFailure() {
        String result = service.trackOrder("ORD999");
        assertTrue(result.contains("ERROR"), "Non-existent order should return error");
    }

    // TEST 5: Update order status
    @Test
    @org.junit.jupiter.api.Order(5)
    void testUpdateOrderStatus() {
        String result = service.updateStatus("ORD001", "DELIVERED");
        assertTrue(result.contains("DELIVERED"), "Status should update to DELIVERED");
    }
}