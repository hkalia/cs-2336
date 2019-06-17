public class Q7_16 {
    public static void main(String[] args) {
        System.out.println("Linear Search Execution Time: " + ExecutionTime.calculateLinearSearchExecutionTime());
        System.out.println("Binary Search Execution Time: " + ExecutionTime.calculateBinarySearchExecutionTime());
    }
}

class ExecutionTime {
    public static long calculateLinearSearchExecutionTime() {
        int[] list = generateRandomArray(100000);
        int key = (int) (Math.random() * 100000);
        long startTime = System.currentTimeMillis();
        int found = linearSearch(list, key);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long calculateBinarySearchExecutionTime() {
        int[] list = generateRandomArray(100000);
        int key = (int) (Math.random() * 100000);
        selectionSort(list);
        long startTime = System.currentTimeMillis();
        int found = binarySearch(list, key);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Generates an array of length size filled with random integers
     */
    public static int[] generateRandomArray(int size) {
        int[] randomList = new int[size];
        for (int i = 0; i < randomList.length; i++) {
            randomList[i] = (int) (Math.random() * (size + 1));
        }
        return randomList;
    }

    /**
     * The method for finding a key in the list
     */
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }

    /**
     * The method for sorting the numbers
     */
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**
     * Use binary search to find the key in the list
     */
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -low - 1; // Now high < low, key not found
    }
}