import java.util.Scanner;
public class Test { 
  public static void main(String[] args) {
    int sum = 0;
    Scanner input;
    for (int i = 0; i < 3; i++) {
      input = new Scanner(System.in); sum += input.nextInt();
    }
    System.out.printf("%d\n", sum);
  }
}