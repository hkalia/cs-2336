import java.util.Scanner;

public class Q5_22 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();
        System.out.print("Number of Years: ");
        int numYears = input.nextInt();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = input.nextDouble() / 100;

        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = AmortizationSchedule.calculateMonthlyPayment(loanAmount, numYears, monthlyInterestRate);
        double totalPayment = AmortizationSchedule.calculateTotalPayment(loanAmount, numYears, monthlyInterestRate);

        System.out.format("\nMonthly Payment: %.2f\n", monthlyPayment);
        System.out.format("Total Payment: %.2f\n\n", totalPayment);
        System.out.println("Payment#    Interest    Principal    Balance");

        AmortizationSchedule.out(loanAmount, numYears, monthlyInterestRate);
        input.close();
    }
}

class AmortizationSchedule {
    static double calculateMonthlyPayment(double loanAmount, int numYears, double monthlyInterestRate) {
        return loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
    }

    static double calculateTotalPayment(double loanAmount, int numYears, double monthlyInterestRate) {
        return calculateMonthlyPayment(loanAmount, numYears, monthlyInterestRate) * numYears * 12;
    }

    static void out(double loanAmount, int numYears, double monthlyInterestRate) {
        double monthlyPayment = calculateMonthlyPayment(loanAmount, numYears, monthlyInterestRate);
        int paymentNum = 1;
        double balance = loanAmount;
        while (balance > 0.01) {
            double interest = balance * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            balance -= principal;
            System.out.format("%-11d %-11.2f %-12.2f %.2f\n", paymentNum++, interest, principal, balance);
        }
    }
}