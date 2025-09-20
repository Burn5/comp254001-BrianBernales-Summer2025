package exercise3;

class Node<T> {
    T element;
    Node<T> next;

    Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }
}