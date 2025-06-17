import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        // Displaying the elements
        System.out.println("Fruits List: " + fruits);

        // Accessing an element
        System.out.println("First Fruit: " + fruits.get(0));

        // Updating an element
        fruits.set(1, "Blueberry");
        System.out.println("After update: " + fruits);

        // Removing an element
        fruits.remove("Mango");
        System.out.println("After removing 'Mango': " + fruits);

        // Looping through elements
        System.out.println("Fruits using loop:");
        for (String fruit : fruits) {
            System.out.println(" - " + fruit);
        }

        // Size of ArrayList
        System.out.println("Total number of fruits: " + fruits.size());
    }
}
