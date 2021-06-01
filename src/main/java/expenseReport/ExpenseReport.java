package expenseReport;


public class ExpenseReport {

    public void printReport(ReportPrinter printer, Bill bill) {

        printer.print("Expenses " + getDate() + "\n");
        for (Expense expense : bill.getExpenses()) {
            printer.print(String.format("%s\t%s\t$%.02f\n",
                    expense.isOverage() ? "X" : " ",
                    expense.getName(), expense.getAmount() / 100.0));
        }
        printer.print(String.format("\nMeal expenses $%.02f", bill.totalMealExpenses() / 100.0));
        printer.print(String.format("\nTotal $%.02f", bill.totalAmount() / 100.0));
    }



    private String getDate() {
        return "9/12/2002";
    }

}
