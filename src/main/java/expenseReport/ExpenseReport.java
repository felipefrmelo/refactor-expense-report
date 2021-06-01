package expenseReport;


public class ExpenseReport {

    private final ReportPrinter printer;


    public ExpenseReport(ReportPrinter printer) {
        this.printer = printer;
    }

    public void printReport(Bill bill) {

        printHeader(printer);
        printExpenses(printer, bill);
        printTotals(printer, bill);
    }

    private void printHeader(ReportPrinter printer) {
        printer.print("Expenses " + getDate() + "\n");
    }

    private void printTotals(ReportPrinter printer, Bill bill) {
        printer.print(String.format("\nMeal expenses $%.02f", bill.totalMealExpenses() / 100.0));
        printer.print(String.format("\nTotal $%.02f", bill.totalAmount() / 100.0));
    }

    private void printExpenses(ReportPrinter printer, Bill bill) {
        for (Expense expense : bill.getExpenses()) {
            printer.print(String.format("%s\t%s\t$%.02f\n",
                    expense.isOverage() ? "X" : " ",
                    expense.getName(), expense.getAmount() / 100.0));
        }
    }


    private String getDate() {
        return "9/12/2002";
    }

}
