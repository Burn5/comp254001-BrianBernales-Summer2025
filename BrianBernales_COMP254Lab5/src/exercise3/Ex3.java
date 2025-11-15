package exercise3;

import java.util.ArrayList;

public class Ex3<K extends Comparable<K>, V> {

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private ArrayList<Entry<K, V>> heap = new ArrayList<>();

    private int parent(int j) {
        return (j - 1) / 2;
    }

    private void swap(int i, int j) {
        Entry<K, V> t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    private void upheap(int j) {
        if (j == 0) return;
        int p = parent(j);
        if (heap.get(j).key.compareTo(heap.get(p).key) >= 0) return;
        swap(j, p);
        upheap(p);
    }

    public void insert(K key, V value) {
        heap.add(new Entry<>(key, value));
        upheap(heap.size() - 1);
    }

    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    public static void main(String[] args) {
        Ex3<Integer, String> pq = new Ex3<>();
        pq.insert(5, "A");
        pq.insert(3, "B");
        pq.insert(7, "C");
        pq.insert(1, "D");
        System.out.println(pq.min().key);
    }
}
