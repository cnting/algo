package bilibili;

/**
 * Created by cnting on 2023/8/17
 */
class MyHashMap<K, V> {
    class MapEntry<K, V> {
        int hash;
        K key;
        V value;
        MapEntry<K, V> next;

        MapEntry(int hash, K key, V value, MapEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MapEntry[] table;
    transient int size;
    int threshold = 8;
    float loadFactor = 0.75f;

    public V put(K key, V value) {
        if (table == null) {
            table = new MapEntry[10];
        }
        if (key == null) return null;
        int hash = hash(key);
        int index = getIndex(hash, table.length);
        for (MapEntry<K, V> e = table[index]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, index);
        size++;
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        if (size >= threshold && table[index] != null) {
            resize(size << 1);
            index = getIndex(hash, table.length);
        }

        createEntry(hash, key, value, index);
    }

    private void createEntry(int hash, K key, V value, int index) {
        MapEntry<K, V> newEntry = new MapEntry<>(hash, key, value, table[index]);
        table[index] = newEntry;
        size++;
    }

    private void resize(int newCapacity) {
        MapEntry<K, V>[] newTable = new MapEntry[newCapacity];
        transform(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);

    }

    private void transform(MapEntry<K, V>[] newTable) {
        int newCapacity = newTable.length;
        for (MapEntry<K, V> e : table) {
            while (null != e) {
                MapEntry<K, V> next = e.next;
                int index = getIndex(e.hash, newCapacity);
                e.next = newTable[index];
                newTable[index] = e;
                e = next;
            }
        }
    }

    private int getIndex(int hash, int length) {
        return hash & length - 1;
    }


    public V get(K key) {
        if (key == null) return null;
        MapEntry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    private MapEntry<K, V> getEntry(K key) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);
        for (MapEntry<K, V> e = table[index]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                return e;
            }
        }
        return null;
    }

    private int hash(K key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void main(String[] args) {
        MyHashMap<Integer, Student> map = new MyHashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(i, new Student("ct" + i));
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(map.get(i).name);
        }
    }

    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
}
