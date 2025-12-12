package Ex2;

import java.util.ArrayList;

public class exercise2 {
    static class UnsortedTableMap<K,V> {
        static class Entry<K,V> {
            K k; V v;
            Entry(K k, V v) { this.k = k; this.v = v; }
        }

        ArrayList<Entry<K,V>> table = new ArrayList<>();

        int findIndex(K key) {
            for (int i = 0; i < table.size(); i++)
                if (key == null ? table.get(i).k == null : key.equals(table.get(i).k))
                    return i;
            return -1;
        }

        V get(K key) {
            int j = findIndex(key);
            return j == -1 ? null : table.get(j).v;
        }

        V put(K key, V value) {
            int j = findIndex(key);
            if (j == -1) { table.add(new Entry<>(key, value)); return null; }
            V old = table.get(j).v;
            table.get(j).v = value;
            return old;
        }

        V putOnlyIfAbsent(K key, V value) {
            int j = findIndex(key);
            if (j == -1) { table.add(new Entry<>(key, value)); return null; }
            return table.get(j).v;
        }
    }

    public static void main(String[] args) {
        UnsortedTableMap<String,Integer> m = new UnsortedTableMap<>();
        m.put("A", 10);
        System.out.println(m.putOnlyIfAbsent("A", 99));
        System.out.println(m.get("A"));
        System.out.println(m.putOnlyIfAbsent("B", 20));
        System.out.println(m.get("B"));
    }
}
