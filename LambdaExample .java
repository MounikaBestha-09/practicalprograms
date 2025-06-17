import java.util.ArrayList;
import java.util.Collections;

public class LambdaExample {
    public static void main(String[] args) {
        // 1. Lambda with Runnable
        Runnable greet = () -> System.out.println("Hello from a lambda Runnable!");
        greet.run();

        // 2. Lambda for sorting a list
        ArrayList<String> names = new ArrayList<>();
        names.add("Mounika");
        names.add("Zara");
        names.add("Anil");
        names.add("Bala");

        // Sort using lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("\nSorted names:");
        names.forEach(name -> System.out.println("- " + name));

        // 3. Lambda with functional interface
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("\nAddition: " + add.operation(5, 3));
        System.out.println("Multiplication: " + multiply.operation(5, 3));
    }
}

// Functional interface
@FunctionalInterface
interface Calculator {
    int operation(int a, int b);
}
