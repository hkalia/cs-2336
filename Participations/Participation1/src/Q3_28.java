import java.util.Scanner;

public class Q3_28 {
    public static void main(String[] args) {
        RectangleDistance check = new RectangleDistance();
        check.solve();
    }
}

class Rectangle {
    double x;
    double y;
    double w;
    double h;

    Rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}

class RectangleDistance {
    boolean checkOverlap(Rectangle r1, Rectangle r2) {
        // check overlap horizontally
        boolean checkX = !((r1.x + r1.w / 2 < r2.x - r2.w / 2) || (r1.x - r1.w / 2 > r2.x + r2.w / 2));
        // check overlap vertically
        boolean checkY = !((r1.y + r1.h / 2 < r2.y - r2.h / 2) || (r1.y - r1.h / 2 > r2.y + r2.h / 2));

        return checkX || checkY;
    }

    int checkInside(Rectangle r1, Rectangle r2) {
        // check if r1 is inside r2
        if (r1.x - r1.w / 2 >= r2.x - r2.w / 2 // left edge
                && r1.x + r1.w / 2 <= r2.x + r2.w / 2 // right edge
                && r1.y + r1.h / 2 <= r2.y + r2.h / 2 // top
                && r1.y - r1.h / 2 >= r2.y - r2.h / 2 // bottom
        ) {
            return 1;
        }
        // check if r2 is inside r1
        if (r2.x - r2.w / 2 >= r1.x - r1.w / 2 // left edge
                && r2.x + r2.w / 2 <= r1.x + r1.w / 2 // right edge
                && r2.y + r2.h / 2 <= r1.y + r1.h / 2 // top
                && r2.y - r2.h / 2 >= r1.y - r1.h / 2 // bottom
        ) {
            return 2;
        }

        return 0;
    }

    void solve() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        Rectangle r1 = new Rectangle(input.nextDouble(),
                input.nextDouble(),
                input.nextDouble(),
                input.nextDouble());
        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        Rectangle r2 = new Rectangle(input.nextDouble(),
                input.nextDouble(),
                input.nextDouble(),
                input.nextDouble());

        if (checkOverlap(r1, r2)) {
            int tmp = checkInside(r1, r2);
            if (tmp == 0) {
                System.out.println("r2 overlaps r1");
            } else if (tmp == 1) {
                System.out.println("r1 is inside r2");
            } else if (tmp == 2) {
                System.out.println("r2 is inside r1");
            }
        } else {
            System.out.println("r2 does not overlap r1");
        }
    }
}