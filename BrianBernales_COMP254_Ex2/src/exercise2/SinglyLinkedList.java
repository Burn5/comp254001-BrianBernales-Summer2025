package exercise2;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public void add(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void swapNodes(Node<T> node1, Node<T> node2) {
        if (node1 == node2) return;
        
        Node<T> prev1 = null;
        Node<T> prev2 = null;
        Node<T> current = head;
        
        while (current != null) {
            if (current.next == node1) prev1 = current;
            if (current.next == node2) prev2 = current;
            current = current.next;
        }
        
        if (node1 == head) {
            prev2.next = node1;
            Node<T> temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
            head = node2;
        } else if (node2 == head) {
            prev1.next = node2;
            Node<T> temp = node2.next;
            node2.next = node1.next;
            node1.next = temp;
            head = node1;
        } else {
            prev1.next = node2;
            prev2.next = node1;
            Node<T> temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
        }
    }

    public Node<T> getHead() { return head; }
}