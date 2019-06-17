import java.util.Scanner;

public class Q5_21 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();
        System.out.print("Number of Years: ");
        int numYears = input.nextInt();
        System.out.println("Interest Rate    Monthly Payment    Total Payment");
        CompareLoan.out(loanAmount, numYears);
        input.close();
    }
}

class CompareLoan {
    static double calculateMonthlyPayment(double loanAmount, int numYears, double monthlyInterestRate) {
        return loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
    }

    static void out(double loanAmount, int numYears) {
        for (double i = 0.05; i <= 0.08000001; i += 0.00125) {
            double monthlyInterestRate = i / 12;
            double monthlyPayment = calculateMonthlyPayment(loanAmount, numYears, monthlyInterestRate);
            double totalPayment = monthlyPayment * numYears * 12;

            System.out.format("%.3f%% %16.2f %20.2f\n", i * 100, monthlyPayment, totalPayment);
        }
    }
}