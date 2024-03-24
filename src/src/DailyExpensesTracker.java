import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DailyExpensesTracker {
    private static class DailyExpense {
        String item;
        double price;

        public DailyExpense(String item, double price) {
            this.item = item;
            this.price = price;
        }
    }

    private Map<String, List<DailyExpense>> dailyExpenses;

    public DailyExpensesTracker() {
        this.dailyExpenses = new HashMap<>();
    }

    public void addDailyExpense(String date, String item, double price) {
        dailyExpenses.putIfAbsent(date, new ArrayList<>());
        dailyExpenses.get(date).add(new DailyExpense(item, price));
    }

    public double calculateDailyExpenses(String date) {
        if (!dailyExpenses.containsKey(date)) {
            return 0;
        }
        return dailyExpenses.get(date).stream().mapToDouble(expense -> expense.price).sum();
    }

    public void displayDailyExpenses(String date) {
        if (!dailyExpenses.containsKey(date)) {
            System.out.println("No expenses for " + date);
            return;
        }
        List<DailyExpense> expenses = dailyExpenses.get(date);
        double totalExpense = 0;
        for (DailyExpense expense : expenses) {
            System.out.println("- " + expense.item + ": $" + expense.price);
            totalExpense += expense.price;
        }
        System.out.println("Total expenses for " + date + ": $" + totalExpense);
    }
}