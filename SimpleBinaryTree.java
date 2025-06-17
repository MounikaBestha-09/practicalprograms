// Node class for the tree
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// BinaryTree class with traversal
public class SimpleBinaryTree {
    // Root node
    Node root;

    // In-order traversal: Left -> Root -> Right
    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();

        // Manually creating the tree
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(20);

        System.out.println("In-order Traversal of Binary Tree:");
        tree.inOrderTraversal(tree.root);
    }
}
