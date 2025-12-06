package exercise1;

public class Ex1 {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static Node treeSearch(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return current;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {40, 20, 60, 10, 30, 50, 70};
        for (int v : values) {
            root = insert(root, v);
        }

        int searchKey = 30;
        Node result = treeSearch(root, searchKey);

        if (result != null) {
            System.out.println("Key " + searchKey + " found in the tree.");
        } else {
            System.out.println("Key " + searchKey + " not found in the tree.");
        }
    }
}

