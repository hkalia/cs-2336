import java.util.Scanner;

public class Q3_22 {
    public static void main(String[] args) {
        CircleDistance check = new CircleDistance();
        check.solve();
    }
}

class CircleDistance {
    double x;
    double y;

    void getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates: ");
        x = input.nextDouble();
        y = input.nextDouble();
    }

    void solve() {
        this.getUserInput();
        double distance = Math.pow(x * x + y * y, 0.5);
        if (distance <= 10) {
            System.out.format("Point (%.1f, %.1f) is in the circle\n", x, y);
        } else if (distance > 10) {
            System.out.format("Point (%.1f, %.1f) is not in the circle\n", x, y);
        }
    }
}