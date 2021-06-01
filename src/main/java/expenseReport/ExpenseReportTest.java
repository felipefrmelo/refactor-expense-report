package expenseReport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpenseReportTest {
    private MockReportPrinter printer = new MockReportPrinter();
    private ExpenseReport report = new ExpenseReport(printer);

    private Bill bill = new Bill();

    @Before
    public void setUp() {
        printer = new MockReportPrinter();
        report = new ExpenseReport(printer);
        bill = new Bill();
    }

    @Test
    public void printEmpty() {
        report.printReport(bill);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        "\n" +
                        "Meal expenses $0,00\n" +
                        "Total $0,00",
                printer.getText());
    }

    @Test
    public void printOneDinner() {
        bill.addExpense(new ExpenseDinner( 1678));
        report.printReport(bill);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$16,78\n" +
                        "\n" +
                        "Meal expenses $16,78\n" +
                        "Total $16,78",
                printer.getText());
    }

    @Test
    public void twoMeals() {
        bill.addExpense(new ExpenseDinner( 1000));
        bill.addExpense(new ExpenseBreakfast( 500));
        report.printReport(bill);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$10,00\n" +
                        " \tBreakfast\t$5,00\n" +

                        "\n" +
                        "Meal expenses $15,00\n" +
                        "Total $15,00",
                printer.getText());
    }

    @Test
    public void twoMealsAndCarRental() {
        bill.addExpense(new ExpenseDinner( 1000));
        bill.addExpense(new ExpenseBreakfast( 500));
        bill.addExpense(new ExpenseCarRental( 50000));
        report.printReport(bill);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$10,00\n" +
                        " \tBreakfast\t$5,00\n" +
                        " \tCar Rental\t$500,00\n" +
                        "\n" +
                        "Meal expenses $15,00\n" +
                        "Total $515,00",
                printer.getText());
    }

    @Test
    public void overages() {
        bill.addExpense(new ExpenseBreakfast( 1000));
        bill.addExpense(new ExpenseBreakfast( 1001));
        bill.addExpense(new ExpenseDinner( 5000));
        bill.addExpense(new ExpenseDinner( 5001));
        report.printReport(bill);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tBreakfast\t$10,00\n" +
                        "X\tBreakfast\t$10,01\n" +
                        " \tDinner\t$50,00\n" +
                        "X\tDinner\t$50,01\n" +
                        "\n" +
                        "Meal expenses $120,02\n" +
                        "Total $120,02",
                printer.getText());
    }

}
