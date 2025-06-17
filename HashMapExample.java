import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap that maps Strings to Integers
        HashMap<String, Integer> scores = new HashMap<>();

        // Adding key-value pairs
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);
        scores.put("David", 90);

        // Display the entire HashMap
        System.out.println("Student Scores: " + scores);

        // Accessing a value by key
        System.out.println("Bob's Score: " + scores.get("Bob"));

        // Updating a value
        scores.put("Alice", 95);
        System.out.println("Updated Alice's Score: " + scores.get("Alice"));

        // Removing a key-value pair
        scores.remove("Charlie");

        // Iterating over entries
        System.out.println("All entries in the map:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        // Checking key existence
        System.out.println("Is 'David' in the map? " + scores.containsKey("David"));

        // Size of the map
        System.out.println("Total students: " + scores.size());
    }
}
