public class Main {
    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        OrderLogs orderLogs = new OrderLogs();
        PizzaOrderQueue orderQueue = new PizzaOrderQueue();
        
        handleOrders.takeOrder();
        handleOrders.createOrderSummary();
        handleOrders.displayCustomPizzas();
        System.out.println(handleOrders);
        
        
        orderLogs.handleLogs();
        orderQueue.manageOrders();
    }
}
