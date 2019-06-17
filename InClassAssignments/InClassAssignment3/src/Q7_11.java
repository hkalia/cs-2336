import java.util.Arrays;
import java.util.Scanner;

public class Q7_11 {
    public static void main(String[] args) {
        System.out.print("Enter ten numbers: ");
        Scanner input = new Scanner(System.in);
        double[] list = new double[10];
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextDouble();
        }
        System.out.format("The mean is %.2f\n", StandardDeviationComputer.mean(list));
        System.out.format("The standard deviation is %.5f\n", StandardDeviationComputer.deviation(list));
    }
}

class StandardDeviationComputer {
    /**
     * Compute the deviation of double values
     */
    public static double deviation(double[] x) {
        double mean = mean(x);
        double sum = Arrays.stream(x).map(v -> Math.pow(v - mean, 2)).sum();
        return Math.sqrt(sum / (x.length - 1));
    }

    /**
     * Compute the mean of an array of double values
     */
    public static double mean(double[] x) {
        return Arrays.stream(x).sum() / x.length;
    }

}