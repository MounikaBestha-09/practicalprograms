import java.util.Arrays;

public class SimpleMinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public SimpleMinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Helper methods to get parent/child indices
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify up
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Swap two elements
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Display the heap as an array
    public void displayHeap() {
        System.out.println("Heap array: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        SimpleMinHeap heap = new SimpleMinHeap(10);

        int[] values = {20, 15, 30, 5, 10, 25};
        for (int val : values) {
            heap.insert(val);
        }

        heap.displayHeap();
    }
}
