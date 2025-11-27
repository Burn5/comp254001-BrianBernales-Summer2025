package exercise2;

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        SortedTableMap map = new SortedTableMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", null);

        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
        System.out.println(map.get("key3"));
        System.out.println(map.containsKey("key1"));
        System.out.println(map.containsKey("key4"));
    }

    static class SortedTableMap {
        private Object[][] table;
        private int size;

        public SortedTableMap() {
            this.table = new Object[100][2];
            this.size = 0;
        }

        public void put(String key, String value) {
            int index = findIndex(key);
            if (index >= 0) {
                table[index][1] = value;
            } else {
                if (size >= table.length) {
                    resize();
                }
                table[size][0] = key;
                table[size][1] = value;
                size++;
            }
        }

        public String get(String key) {
            int index = findIndex(key);
            if (index >= 0) {
                return (String) table[index][1];
            }
            return null;
        }

        public boolean containsKey(String key) {
            int index = findIndex(key);
            return index >= 0;
        }

        private int findIndex(String key) {
            for (int i = 0; i < size; i++) {
                if (table[i][0].equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        private void resize() {
            table = Arrays.copyOf(table, table.length * 2);
        }
    }
}