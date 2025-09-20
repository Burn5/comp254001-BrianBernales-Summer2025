package exercise1;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
        size = 0;
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }
    
    public void print() {
        Node<T> current = head.next;
        while (current != tail) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static <T> DoublyLinkedList<T> join(DoublyLinkedList<T> first, DoublyLinkedList<T> second) {
        if (first.size == 0) return second;
        if (second.size == 0) return first;
        
        first.tail.prev.next = second.head.next;
        second.head.next.prev = first.tail.prev;
        
        first.tail = second.tail;
        first.size += second.size;
        
        return first;
    }
}