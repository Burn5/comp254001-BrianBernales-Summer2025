package exercise3;

public class CircularlyLinkedList<T> {
    private Node<T> tail;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print() {
        if (tail == null) return;
        Node<T> current = tail.next;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public CircularlyLinkedList<T> clone() {
        CircularlyLinkedList<T> newList = new CircularlyLinkedList<>();
        if (tail == null) return newList;
        
        Node<T> current = tail.next;
        for (int i = 0; i < size; i++) {
            newList.add(current.element);
            current = current.next;
        }
        return newList;
    }
}