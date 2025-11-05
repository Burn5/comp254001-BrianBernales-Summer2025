package exercise1;

public class Ex1 {
    interface Position<E> { E getElement(); }

    interface PositionalList<E> {
        Position<E> first();
        Position<E> after(Position<E> p);
        Position<E> addLast(E e);
        int indexOf(Position<E> p);
    }

    static class LinkedPositionalList<E> implements PositionalList<E> {
        private static class Node<T> implements Position<T> {
            T e; Node<T> next;
            Node(T e, Node<T> next) { this.e = e; this.next = next; }
            public T getElement() { return e; }
        }
        private Node<E> head, tail;
        private int size;

        public Position<E> first() { return head; }
        public Position<E> after(Position<E> p) { return ((Node<E>) p).next; }
        public Position<E> addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (tail == null) { head = tail = newest; }
            else { tail.next = newest; tail = newest; }
            size++;
            return newest;
        }
        public int indexOf(Position<E> p) {
            int i = 0;
            for (Position<E> walk = first(); walk != null; walk = after(walk)) {
                if (walk == p) return i;
                i++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        Position<Integer> a = list.addLast(10);
        Position<Integer> b = list.addLast(20);
        Position<Integer> c = list.addLast(30);
        System.out.println(list.indexOf(a)); // 0
        System.out.println(list.indexOf(b)); // 1
        System.out.println(list.indexOf(c)); // 2
    }
}
