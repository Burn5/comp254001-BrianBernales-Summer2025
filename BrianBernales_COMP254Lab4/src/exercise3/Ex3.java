package exercise3;

public class Ex3 {
    public static class LinkedQueue<E> {
        private static class Node<E> { E e; Node<E> next; Node(E e){ this.e=e; } }
        private Node<E> head, tail;
        private int size;

        public boolean isEmpty(){ return size==0; }
        public int size(){ return size; }
        public E first(){ return head==null?null:head.e; }

        public void enqueue(E e){
            Node<E> n = new Node<>(e);
            if (tail==null) { head=tail=n; } else { tail.next=n; tail=n; }
            size++;
        }

        public E dequeue(){
            if (head==null) return null;
            E val=head.e;
            head=head.next;
            if (head==null) tail=null;
            size--;
            return val;
        }

        public void concatenate(LinkedQueue<E> Q2){
            if (Q2==null || Q2.isEmpty()) return;
            if (this.isEmpty()){
                this.head = Q2.head;
                this.tail = Q2.tail;
                this.size = Q2.size;
            } else {
                this.tail.next = Q2.head;
                this.tail = Q2.tail;
                this.size += Q2.size;
            }
            Q2.head = null;
            Q2.tail = null;
            Q2.size = 0;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder("[");
            Node<E> c=head;
            while(c!=null){ sb.append(c.e); c=c.next; if(c!=null) sb.append(", "); }
            return sb.append("]").toString();
        }
    }

    public static void main(String[] args){
        LinkedQueue<Integer> a = new LinkedQueue<>();
        LinkedQueue<Integer> b = new LinkedQueue<>();
        a.enqueue(1);
        a.enqueue(2);
        b.enqueue(3);
        b.enqueue(4);
        b.enqueue(5);
        a.concatenate(b);
        System.out.println(a); // [1, 2, 3, 4, 5]
        System.out.println(b); // []
        System.out.println(a.size()); // 5
        System.out.println(b.size()); // 0
    }
}
