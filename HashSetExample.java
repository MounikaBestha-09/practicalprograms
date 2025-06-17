import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet of strings
        HashSet<String> animals = new HashSet<>();

        // Adding elements
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        animals.add("Tiger");
        animals.add("Dog"); // Duplicate, will be ignored

        // Display the HashSet
        System.out.println("Animals: " + animals);

        // Check if an element exists
        System.out.println("Contains 'Cat'? " + animals.contains("Cat"));

        // Remove an element
        animals.remove("Elephant");
        System.out.println("After removing 'Elephant': " + animals);

        // Iterating through the HashSet
        System.out.println("List of animals:");
        for (String animal : animals) {
            System.out.println(" - " + animal);
        }

        // Size of the HashSet
        System.out.println("Total number of animals: " + animals.size());
    }
}
