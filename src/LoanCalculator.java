import java.util.InputMismatchException;
import java.util.Scanner;
public class LoanCalculator {
    private Loan loan;


    public LoanCalculator() {
        loan = new Loan(100000,15,10);
    }
    private void displayOutput() {
        System.out.println("Loan Amount: $" + loan.getAmount());

        System.out.println("Annual Interest Rate:"
                + loan.getRate() + "%");
        System.out.println("Loan Period (years): " + loan.getPeriod());

        computePayment();
    }

    private void getInput() {
        double loanAmount, annualInterestRate;
        int loanPeriod;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Loan Amount (Dollars+Cents): ");
                loanAmount = scanner.nextDouble();
                loan.setAmount(loanAmount);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid loan amount.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Annual Interest Rate (e.g., 9.5): ");
                annualInterestRate = scanner.nextDouble();
                loan.setRate(annualInterestRate);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid interest rate.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Loan Period - # of years: ");
                loanPeriod = scanner.nextInt();
                loan.setPeriod(loanPeriod);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid loan period.");
                scanner.nextLine();
            }
        }
    }

    private void describeProgram() {
        System.out.println
                ("This program computes the monthly and total");
        System.out.println
                ("payments for a given loan amount, annual ");
        System.out.println
                ("interest rate, and loan period (# of years).");
        System.out.println("\n");
    }

    // Computes the monthly and total loan payments
    /*
    * Given three parameters—loan amount,
loan period, and interest rate—it computes monthly and total payments.
The actual computation is done by a
Loan object.
*
* */
    private void computePayment() {
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();
        System.out.println("Monthly payment: $" + monthlyPayment);
        System.out.println("Total payment: $" + totalPayment);
    }

    public void start() {
        describeProgram(); //tell what the program does
        getInput(); //get three input values
        computePayment(); //compute the monthly payment and total
        displayOutput(); //display the results
    }

    public static void main(String[] arg) {
        LoanCalculator calculator = new LoanCalculator();
        calculator.start();
    }
}
