import java.util.*;

public class SimpleDFSGraph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public SimpleDFSGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Remove for directed graph
    }

    // DFS helper function
    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal starting from node " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleDFSGraph graph = new SimpleDFSGraph(6);

        // Creating a sample undirected graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform DFS
        graph.dfs(0);
    }
}
