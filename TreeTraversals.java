// Node class for the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// Tree class with traversal methods
public class TreeTraversals {
    Node root;

    // In-order traversal
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Pre-order traversal
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order traversal
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();

        // Manually creating the tree
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("In-order Traversal:");
        tree.inOrder(tree.root);

        System.out.println("\nPre-order Traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nPost-order Traversal:");
        tree.postOrder(tree.root);
    }
}
