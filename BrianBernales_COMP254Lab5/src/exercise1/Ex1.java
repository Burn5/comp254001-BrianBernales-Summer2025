package exercise1;

public class Ex1 {

    static class Node<E> {
        E element;
        Node<E> left, right, parent;

        Node(E e, Node<E> parent) {
            this.element = e;
            this.parent = parent;
        }
    }

    static <E> Node<E> inorderNext(Node<E> p) {
        if (p == null) return null;
        if (p.right != null) {
            Node<E> x = p.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
        Node<E> x = p;
        Node<E> parent = x.parent;
        while (parent != null && parent.right == x) {
            x = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(2, null);
        root.left = new Node<>(1, root);
        root.right = new Node<>(3, root);

        System.out.println(inorderNext(root.left).element);
        System.out.println(inorderNext(root).element);
        System.out.println(inorderNext(root.right));
    }
}
