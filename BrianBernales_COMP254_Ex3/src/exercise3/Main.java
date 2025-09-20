package exercise3;

public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("Original: ");
        list.print();

        CircularlyLinkedList<Integer> copy = list.clone();
        System.out.print("Clone: ");
        copy.print();
    }
}