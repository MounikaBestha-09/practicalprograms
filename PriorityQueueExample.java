import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue of integers (min-heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.add(5);

        // Display the priority queue (order is not sorted in output!)
        System.out.println("PriorityQueue (heap structure): " + pq);

        // Remove elements using poll() (removes smallest first)
        System.out.println("Polling elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
