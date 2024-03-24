import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task toDoList = new task();

        System.out.println("ToDo List and Daily Expenses Tracker");
        System.out.println("-------------------------------------");
        boolean running = true;

        while (running) {
            System.out.println("\nOptions: [1] Add Task [2] Complete Task [3] Remove Task [4] Add Expense [5] Show Expenses [6] Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1: // Add Task
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    toDoList.addTask(taskDescription);
                    break;
                case 2: // Complete Task
                    toDoList.displayTasks();
                    System.out.print("Enter task number to complete: ");
                    int completeTaskIndex = scanner.nextInt() - 1;
                    toDoList.completeTask(completeTaskIndex);
                    break;
                case 3: // Remove Task
                    toDoList.displayTasks();
                    System.out.print("Enter task number to remove: ");
                    int removeTaskIndex = scanner.nextInt() - 1;
                    toDoList.removeTask(removeTaskIndex);
                    break;
                case 4: // Add Expense
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String item = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    toDoList.addDailyExpense(date, item, price);
                    break;
                case 5: // Show Expenses
                    System.out.print("Enter date (YYYY-MM-DD) to show expenses for: ");
                    String expenseDate = scanner.nextLine();
                    toDoList.displayDailyExpenses(expenseDate);
                    break;
                case 6: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
}
}

