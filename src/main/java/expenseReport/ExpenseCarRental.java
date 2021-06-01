package expenseReport;


public class ExpenseCarRental extends Expense {

    public ExpenseCarRental(int amount) {
        super(amount);
    }

    boolean isOverage() {
        return false;
    }

    String getName() {
        return "Car Rental";
    }

    @Override
    boolean isMeal() {
        return false;
    }


}
