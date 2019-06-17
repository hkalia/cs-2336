public class Q5_23 {
  public static void main(String[] args) {
    System.out.println("left to right: " + DemonstrateCancellation.leftToRight(50000));
    System.out.format("right to left: " + DemonstrateCancellation.rightToLeft(50000));
  }
}

class DemonstrateCancellation {
  static double leftToRight(int n) {
    double sum = 0;
    for (double i = 1; i <= n; i++) {
      sum += 1 / i;
    }
    return sum;
  }

  static double rightToLeft(int n) {
    double sum = 0;
    for (double i = n; i >= 1; i--) {
      sum += 1 / i;
    }
    return sum;
  }
}