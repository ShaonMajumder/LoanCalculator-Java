public class Loan {
    private final int MONTHS_IN_YEAR = 12;
    private double loanAmount;
    private double monthlyInterestRate;
    private int numberOfPayments;

    // Constructor
    public Loan(double amount, double rate, int period) throws IllegalArgumentException {
        setAmount(amount);
        setRate(rate);
        setPeriod(period);
    }

    // Returns the loan amount
    public double getAmount() {
        return loanAmount;
    }

    // Returns the loan period in number of years
    public int getPeriod() {
        return numberOfPayments / MONTHS_IN_YEAR;
    }

    // Returns the loan's annual interest rate
    public double getRate() {
        return monthlyInterestRate * 100.0 * MONTHS_IN_YEAR;
    }

    // Sets the loan amount
    public void setAmount(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        loanAmount = amount;
    }

    // Sets the annual interest rate
    public void setRate(double annualRate) throws IllegalArgumentException {
        if (annualRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than zero.");
        }
        monthlyInterestRate = annualRate / 100.0 / MONTHS_IN_YEAR;
    }

    // Sets the loan period
    public void setPeriod(int periodInYears) throws IllegalArgumentException {
        if (periodInYears <= 0) {
            throw new IllegalArgumentException("Loan period must be greater than zero.");
        }
        numberOfPayments = periodInYears * MONTHS_IN_YEAR;
    }

    public double getMonthlyPayment() {
        assert loanAmount > 0 : "Loan amount must be greater than zero.";
        assert monthlyInterestRate > 0 : "Monthly interest rate must be greater than zero.";
        assert numberOfPayments > 0 : "Number of payments must be greater than zero.";

        double monthlyPayment;
        monthlyPayment = (loanAmount * monthlyInterestRate)
                /
                (1 - Math.pow(1 / (1 + monthlyInterestRate), numberOfPayments));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        assert loanAmount > 0 : "Loan amount must be greater than zero.";
        assert numberOfPayments > 0 : "Number of payments must be greater than zero.";

        double totalPayment;
        totalPayment = getMonthlyPayment() * numberOfPayments;
        return totalPayment;
    }
}
