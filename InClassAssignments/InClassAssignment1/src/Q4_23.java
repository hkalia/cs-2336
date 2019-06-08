import java.util.Scanner;

public class Q4_23 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee's name: ");
        String name = input.nextLine();
        System.out.print("Enter number of hours worked in a week: ");
        double hours = input.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        double payRate = input.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        double fedRate = input.nextDouble();
        System.out.print("Enter state tax withholding rate: ");
        double stateRate = input.nextDouble();

        System.out.println("Employee Name: " + name);
        System.out.format("Hours Worked: %.1f\n", hours);
        System.out.format("Pay Rate: $%.2f\n", payRate);
        System.out.format("Gross Pay: $%.2f\n", Payroll.calculateGrossPay(hours, payRate));
        System.out.println("Deductions:");
        double fedWithhold = Payroll.calculateFedWithhold(hours, payRate, fedRate);
        double stateWithhold = Payroll.calculateStateWithhold(hours, payRate, stateRate);
        System.out.format("  Federal Withholding (%.1f%%): $%.2f\n", fedRate * 100, fedWithhold);
        System.out.format("  State Withholding (%.1f%%): $%.2f\n", stateRate * 100, stateWithhold);
        System.out.format("  Total Deduction: $%.2f\n", fedWithhold + stateWithhold);
        System.out.format("Net Pay: $%.2f\n", hours * payRate - fedWithhold - stateWithhold);
    }
}

class Payroll {
    static double calculateGrossPay(double hours, double payRate) {
        return hours * payRate;
    }

    static double calculateFedWithhold(double hours, double payRate, double fedRate) {
        return hours * payRate * fedRate;
    }

    static double calculateStateWithhold(double hours, double payRate, double stateRate) {
        return hours * payRate * stateRate;
    }
}