public class Record {
    private String type; 
    private double amount; 
    private String description; 

    public Record(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f, %s", type, amount, description);
    }
}
