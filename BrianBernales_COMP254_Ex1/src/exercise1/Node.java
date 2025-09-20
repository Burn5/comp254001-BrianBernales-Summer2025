package exercise1;

public class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;
    
    Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}