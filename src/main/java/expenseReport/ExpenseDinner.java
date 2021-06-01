package expenseReport;


public class ExpenseDinner extends Expense {

    public ExpenseDinner(int amount) {
        super(amount);
    }

    boolean isOverage() {
        return getAmount() > 5000;
    }

    String getName() {
        return "Dinner";
    }

    boolean isMeal() {
        return true;
    }

}
