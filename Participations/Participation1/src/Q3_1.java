import java.util.Scanner;

public class Q3_1 {

    public static void main(String[] args) {
        QuadraticSolver solver = new QuadraticSolver();
        solver.solve();
    }
}

class QuadraticSolver {

    double a;
    double b;
    double c;

    void getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
    }

    void solve() {
        this.getUserInput();
        double discriminant = Math.pow(b, 2) - 4*a*c;
        if (discriminant > 0) {
            System.out.format("The equation has two roots %f and %f\n",
                    (-1 * b + Math.pow(discriminant, 0.5)) / 2 * a,
                    (-1 * b - Math.pow(discriminant, 0.5)) / 2 * a);
        } else if (discriminant == 0) {
            System.out.format("The equation has one root %f\n",
                    (-1 * b + Math.pow(discriminant, 0.5)) / 2 * a);
        } else if (discriminant < 0) {
            System.out.println("The equation has no real roots\n");
        } else {
            System.out.println("error\n");
        }
    }
}