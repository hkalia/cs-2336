import java.util.Scanner;

public class Q7_32 {

    public static void main(String[] args) {
        System.out.print("Enter list: ");
        Scanner input = new Scanner(System.in);
        int arrLen = input.nextInt();
        int[] list = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            list[i] = input.nextInt();
        }
        ListPartitioner.partition(list);
        System.out.print("After the partition, the list is ");
        for (int i = 0; i < arrLen; i++) {
            System.out.print(list[i] + " ");
        }
    }
}

class ListPartitioner {
    public static int partition(int[] list) {
        int pivot = list[0];
        int[] partitionedList = new int[list.length];
        int start = 0;
        int end = list.length - 1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] <= pivot) {
                partitionedList[start++] = list[i];
            } else {
                partitionedList[end--] = list[i];
            }
        }
        partitionedList[start] = pivot;
        System.arraycopy(partitionedList, 0, list, 0, list.length);
        return start;
    }
}