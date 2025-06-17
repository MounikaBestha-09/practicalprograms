// Node class for BST
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// Binary Search Tree implementation
public class SimpleBST {
    Node root;

    // Insert a new node
    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    // In-order traversal (Left, Root, Right)
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        SimpleBST bst = new SimpleBST();

        // Insert values
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.root = bst.insert(bst.root, val);
        }

        // Display in-order traversal
        System.out.println("In-order Traversal (Sorted Order):");
        bst.inOrderTraversal(bst.root);
    }
}
