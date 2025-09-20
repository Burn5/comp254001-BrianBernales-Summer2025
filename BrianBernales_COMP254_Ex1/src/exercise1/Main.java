package exercise1;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        
        System.out.print("List 1: ");
        list1.print();
        
        System.out.print("List 2: ");
        list2.print();
        
        DoublyLinkedList<Integer> result = DoublyLinkedList.join(list1, list2);
        
        System.out.print("Joined: ");
        result.print();
    }
}