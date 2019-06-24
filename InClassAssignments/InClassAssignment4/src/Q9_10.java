import java.util.Scanner;

public class Q9_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        QuadraticEquation equation = new QuadraticEquation(input.nextDouble(), input.nextDouble(), input.nextDouble());
        double discriminant = equation.getDiscriminant();
        if (discriminant > 0) {
            System.out.format("The equation has two roots %f and %f\n", equation.getRoot1(), equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.format("The equation has one root %f\n", equation.getRoot1());
        } else if (discriminant < 0) {
            System.out.println("The equation has no real roots");
        } else {
            System.out.println("error");
        }
    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    double getRoot1() {
        double discriminant = getDiscriminant();
        return discriminant < 0 ? 0 : (-1 * b + Math.pow(discriminant, 0.5)) / 2 * a;
    }

    double getRoot2() {
        double discriminant = getDiscriminant();
        return discriminant < 0 ? 0 : (-1 * b - Math.pow(discriminant, 0.5)) / 2 * a;
    }
}