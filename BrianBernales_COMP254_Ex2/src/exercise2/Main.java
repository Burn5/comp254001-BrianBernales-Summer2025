package exercise2;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original List:");
        list.print();

        Node<Integer> node1 = list.getHead().next;
        Node<Integer> node2 = node1.next;

        list.swapNodes(node1, node2);

        System.out.println("After swapping:");
        list.print();
    }
}