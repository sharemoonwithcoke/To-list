import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task {
    private static class Task {
        String description;
        boolean completed;

        public Task(String description) {
            this.description = description;
            this.completed = false;
        }

        public void complete() {
            this.completed = true;
        }
    }

    private static class DailyExpense {
        String item;
        double price;

        public DailyExpense(String item, double price) {
            this.item = item;
            this.price = price;
        }
    }

    private List<Task> tasks;
    private Map<String, List<DailyExpense>> dailyExpenses;

    public task() {
        this.tasks = new ArrayList<>();
        this.dailyExpenses = new HashMap<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        }
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

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.description + (task.completed ? " (completed)" : ""));
        }
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