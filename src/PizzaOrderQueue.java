import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PizzaOrderQueue {
    private Queue<String> orderQueue;
    
    public PizzaOrderQueue() {
        orderQueue = new LinkedList<>();
    }
    
    public void addOrder(String order) {
        orderQueue.offer(order);
    }
    
    public void displayNextOrder() {
        System.out.println("Next order to process: " + orderQueue.peek());
    }
    
    public String processOrder() {
        return orderQueue.poll();
    }
    
    public void clearOrders() {
        orderQueue.clear();
    }
    
    public boolean isQueueEmpty() {
        return orderQueue.isEmpty();
    }
    
    public void manageOrders() {
        Scanner input = new Scanner(System.in);
        String continueChoice;
        
        do {
            System.out.println("\nPizza Order Queue Management:");
            System.out.println("1. Display all orders in queue");
            System.out.println("2. View next order");
            System.out.println("3. Process next order");
            System.out.println("4. Clear all orders");
            System.out.println("5. Check if queue is empty");
            System.out.println("Enter your choice (1-5):");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice) {
                case 1:
                    displayAllOrders();
                    break;
                case 2:
                    if(!isQueueEmpty()) {
                        displayNextOrder();
                    } else {
                        System.out.println("No orders in queue");
                    }
                    break;
                case 3:
                    if(!isQueueEmpty()) {
                        System.out.println("Processed order: " + processOrder());
                    } else {
                        System.out.println("No orders to process");
                    }
                    break;
                case 4:
                    clearOrders();
                    System.out.println("All orders cleared");
                    break;
                case 5:
                    System.out.println(isQueueEmpty() ? 
                        "Order queue is empty" : 
                        "Orders are waiting to be processed");
                    break;
            }
            
            System.out.println("Continue managing orders? (Y/N):");
            continueChoice = input.nextLine();
            
        } while(continueChoice.equalsIgnoreCase("Y"));
    }
    
    private void displayAllOrders() {
        for(String order : orderQueue) {
            System.out.println(order);
        }
    }
}
