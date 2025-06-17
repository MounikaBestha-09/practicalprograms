import java.util.*;

public class SimpleGraph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public SimpleGraph(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];

        // Initialize each list
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // comment this line for directed graph
    }

    // Print the graph
    public void printGraph() {
        System.out.println("Graph Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " → ");
            for (Integer node : adjacencyList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the graph
        graph.printGraph();
    }
}
