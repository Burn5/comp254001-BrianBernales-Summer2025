package exercise2;

public class Node<T> {
    T element;
    Node<T> next;

    Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }
}