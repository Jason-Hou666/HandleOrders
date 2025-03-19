import java.util.ArrayDeque;
import java.util.Scanner;

public class OrderLogs {
    private ArrayDeque<String> orderLogs;
    
    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }
    
    public void addOrderLog(String log) {
        orderLogs.push(log);
    }
    
    private void mostRecentLogEntry() {
        System.out.println("Most recent log: " + orderLogs.peek());
    }
    
    private String getOrderLog() {
        return orderLogs.pop();
    }
    
    private void removeAllLogEntries() {
        orderLogs.clear();
    }
    
    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }
    
    public void handleLogs() {
        Scanner input = new Scanner(System.in);
        String continueChoice;
        
        do {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.println("Enter your choice (1 – 5):");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice) {
                case 1:
                    displayOrderLogs();
                    break;
                case 2:
                    if(!orderLogsEmpty()) {
                        mostRecentLogEntry();
                    } else {
                        System.out.println("Log is empty");
                    }
                    break;
                case 3:
                    if(!orderLogsEmpty()) {
                        System.out.println("Removed log: " + getOrderLog());
                    } else {
                        System.out.println("Log is empty");
                    }
                    break;
                case 4:
                    removeAllLogEntries();
                    System.out.println("All logs have been removed");
                    break;
                case 5:
                    System.out.println(orderLogsEmpty() ? 
                        "The log is completely empty" : 
                        "The log is not completely empty");
                    break;
            }
            
            System.out.println("Do you want to continue managing logs? (Y/N):");
            continueChoice = input.nextLine();
            
        } while(continueChoice.equalsIgnoreCase("Y"));
    }
    
    private void displayOrderLogs() {
        for(String log : orderLogs) {
            System.out.println(log);
        }
    }
}
