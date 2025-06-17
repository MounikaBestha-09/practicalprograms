import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList of Strings
        LinkedList<String> cities = new LinkedList<>();

        // Adding elements
        cities.add("New York");
        cities.add("London");
        cities.add("Paris");
        cities.add("Tokyo");

        // Displaying the list
        System.out.println("Cities: " + cities);

        // Adding elements at specific positions
        cities.addFirst("Sydney");
        cities.addLast("Toronto");
        System.out.println("After adding first and last: " + cities);

        // Accessing elements
        System.out.println("First city: " + cities.getFirst());
        System.out.println("Last city: " + cities.getLast());

        // Removing elements
        cities.remove("Paris");
        System.out.println("After removing 'Paris': " + cities);

        // Looping through the list
        System.out.println("All cities:");
        for (String city : cities) {
            System.out.println(" - " + city);
        }

        // Size of LinkedList
        System.out.println("Total number of cities: " + cities.size());
    }
}
