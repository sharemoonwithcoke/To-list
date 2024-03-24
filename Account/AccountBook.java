import java.util.ArrayList;
import java.util.List;

public class AccountBook {
    private List<Record> records;

    public AccountBook() {
        this.records = new ArrayList<>();
    }

    public void addRecord(String type, double amount, String description) {
        Record record = new Record(type, amount, description);
        records.add(record);
    }

    public void showRecords() {
        double totalIncome = 0.0;
        double totalExpense = 0.0;
        for (Record record : records) {
            System.out.println(record);
            if (record.getType().equals("income")) {
                totalIncome += record.getAmount();
            } else if (record.getType().equals("expense")) {
                totalExpense += record.getAmount();
            }
        }
        double balance = totalIncome - totalExpense;
        System.out.println("total income $" + totalIncome);
        System.out.println("total expen: $" + totalExpense);
        System.out.println("banlance:" + balance);
    }
}
