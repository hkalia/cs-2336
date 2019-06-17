import java.util.Scanner;
import java.util.stream.IntStream;

public class Q7_15 {
    public static void main(String[] args) {
        System.out.print("Enter ten numbers: ");
        Scanner input = new Scanner(System.in);
        int[] list = new int[10];
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextInt();
        }
        list = DuplicateRemover.eliminateDuplicates(list);
        System.out.print("The distinct numbers are: ");
        for (int v : list) {
            System.out.print(v + " ");
        }
    }
}

class DuplicateRemover {
    public static int[] eliminateDuplicates(int[] list) {
        int[] tmp = new int[list.length];
        int i = 0;
        for (int value : list) {
            if (IntStream.of(tmp).noneMatch(x -> x == value)) {
                tmp[i++] = value;
            }
        }
        int[] uniqueList = new int[i];
        for (i = 0; i < uniqueList.length; i++) {
            uniqueList[i] = tmp[i];
        }
        return uniqueList;
    }
}