package expenseReport;


public abstract class Expense {

    private final int amount;

    public Expense(int amount) {
        this.amount = amount;
    }


    int getAmount() {
        return amount;
    }

    String getName() {
        return "TILT";
    }

    abstract boolean isOverage();

    abstract boolean isMeal();


    ;



}
