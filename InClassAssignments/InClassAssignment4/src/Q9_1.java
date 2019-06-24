public class Q9_1 {

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4, 40);
        Rectangle rec2 = new Rectangle(3.5, 35.9);
        System.out.format("First Rectangle:\n width: %.2f height: %.2f area: %.2f perimeter: %.2f\n",
                rec1.width, rec1.height, rec1.getArea(), rec1.getPerimeter());
        System.out.format("Second Rectangle:\n width: %.2f height: %.2f area: %.2f perimeter: %.2f\n",
                rec2.width, rec2.height, rec2.getArea(), rec2.getPerimeter());
    }
}

class Rectangle {
    double width = 1;
    double height = 1;

    Rectangle() {
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return this.width * this.height;
    }

    double getPerimeter() {
        return this.width * 2 + this.height * 2;
    }

}