import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountBook accountBook = new AccountBook();

        while (true) {
            System.out.println("1. add a record 2. show records 3. exit");
            int operation = scanner.nextInt();
            scanner.nextLine(); 

            if (operation == 1) {
                System.out.println("type(income/expense)");
                String type = scanner.nextLine();
                System.out.println("please enter the amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("please enter the description:");
                String description = scanner.nextLine();

                accountBook.addRecord(type, amount, description);
            } else if (operation == 2) {
                accountBook.showRecords();
            } else {
                break;
            }
        }
    }
}
