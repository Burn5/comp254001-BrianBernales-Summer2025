package Ex1;

public class exercise1 {
    static class LinkedBinaryTree<E> {
        static class Node<E> {
            E e;
            Node<E> left, right;
            Node(E e) { this.e = e; }
        }

        Node<E> root;

        Node<E> addRoot(E e) { return root = new Node<>(e); }
        Node<E> addLeft(Node<E> p, E e) { return p.left = new Node<>(e); }
        Node<E> addRight(Node<E> p, E e) { return p.right = new Node<>(e); }

        int pathLength() { return pathLength(root, 0); }

        int pathLength(Node<E> n, int d) {
            if (n == null) return 0;
            return d + pathLength(n.left, d + 1) + pathLength(n.right, d + 1);
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
        var r = t.addRoot(1);
        var a = t.addLeft(r, 2);
        t.addRight(r, 3);
        t.addLeft(a, 4);
        t.addRight(a, 5);
        System.out.println(t.pathLength());
    }
}