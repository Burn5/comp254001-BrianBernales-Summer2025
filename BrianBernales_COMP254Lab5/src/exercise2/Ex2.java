package exercise2;

public class Ex2 {

    static class Node<E> {
        E element;
        Node<E> left, right;

        Node(E e) {
            this.element = e;
        }
    }

    static <E> int postorderHeight(Node<E> p) {
        if (p == null) return -1;
        int hl = postorderHeight(p.left);
        int hr = postorderHeight(p.right);
        int h = 1 + Math.max(hl, hr);
        System.out.println(p.element + " " + h);
        return h;
    }

    public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");

        A.left = B;
        A.right = C;
        C.left = D;

        postorderHeight(A);
    }
}
