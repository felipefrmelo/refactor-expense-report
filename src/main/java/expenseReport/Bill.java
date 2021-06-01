package expenseReport;

import java.util.ArrayList;
import java.util.List;


public class Bill {


    private final List<Expense> expenses = new ArrayList<>();

    public List<Expense> getExpenses() {
        return expenses;
    }

    public int totalAmount() {
        return expenses.stream()
                .map(Expense::getAmount)
                .reduce(0, Integer::sum);
    }

    public int totalMealExpenses() {
        return expenses.stream()
                .filter(Expense::isMeal)
                .map(Expense::getAmount)
                .reduce(0, Integer::sum);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }


}
