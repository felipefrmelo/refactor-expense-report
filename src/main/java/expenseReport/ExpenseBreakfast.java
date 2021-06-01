package expenseReport;


public class ExpenseBreakfast extends Expense {

    public ExpenseBreakfast(int amount) {
        super(amount);
    }

    boolean isOverage() {
        return getAmount() > 1000;
    }

    String getName() {
        return "Breakfast";
    }

    boolean isMeal() {
        return true;
    }
}
