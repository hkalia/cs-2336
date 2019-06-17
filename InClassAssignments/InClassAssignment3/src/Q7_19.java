import java.util.Scanner;

public class Q7_19 {
    public static void main(String[] args) {
        System.out.print("Enter list: ");
        Scanner input = new Scanner(System.in);
        int arrLen = input.nextInt();
        int[] list = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            list[i] = input.nextInt();
        }
        System.out.println("The list is " + (checkSorted.isSorted(list) ? "already sorted" : "not sorted"));
    }
}

class checkSorted {
    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
