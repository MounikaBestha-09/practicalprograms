public class BubbleSortExample {
    // Bubble sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparisons
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped)
                break;
        }
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array using Bubble Sort:");
        printArray(arr);
    }
}
