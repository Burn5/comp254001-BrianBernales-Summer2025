package exercise1;

public class Ex1 {

    public static void main(String[] args) {
        ChainHashMap map1 = new ChainHashMap(0.7);
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        System.out.println(map1.get("key1"));
        System.out.println(map1.get("key2"));

        ProbeHashMap map2 = new ProbeHashMap();
        map2.put("key3", "value3");
        map2.put("key4", "value4");
        System.out.println(map2.get("key3"));
        System.out.println(map2.get("key4"));
    }

    static abstract class AbstractHashMap {
        protected double maxLoadFactor;
        protected int size;
        protected int capacity;
        protected Object[] table;

        public AbstractHashMap(double maxLoadFactor) {
            this.maxLoadFactor = maxLoadFactor;
            this.size = 0;
            this.capacity = 100;
            this.table = new Object[capacity];
        }

        public void setLoadFactor(double factor) {
            this.maxLoadFactor = factor;
        }

        public void resize() {
            if ((double) size / capacity > maxLoadFactor) {
                int newCapacity = capacity * 2;
                Object[] newTable = new Object[newCapacity];
                for (Object item : table) {
                    if (item != null) {
                        Entry entry = (Entry) item;
                        int index = Math.abs(entry.key.hashCode()) % newCapacity;
                        while (newTable[index] != null) {
                            index = (index + 1) % newCapacity;
                        }
                        newTable[index] = entry;
                    }
                }
                table = newTable;
                capacity = newCapacity;
            }
        }

        public void put(String key, String value) {
            resize();
            int index = Math.abs(key.hashCode()) % capacity;
            while (table[index] != null) {
                index = (index + 1) % capacity;
            }
            table[index] = new Entry(key, value);
            size++;
        }

        public String get(String key) {
            int index = Math.abs(key.hashCode()) % capacity;
            while (table[index] != null) {
                Entry entry = (Entry) table[index];
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                index = (index + 1) % capacity;
            }
            return null;
        }

        private class Entry {
            String key;
            String value;

            Entry(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    static class ChainHashMap extends AbstractHashMap {

        public ChainHashMap(double maxLoadFactor) {
            super(maxLoadFactor);
        }
    }

    static class ProbeHashMap extends AbstractHashMap {

        public ProbeHashMap() {
            super(0.5);
        }
    }
}