package br.com.mhbp.datastructure.hashtable.generic;

public class HashTable<K, V> {
    K[] keys;
    V[] values;
    int numItems;
    int capacity = 10;


    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    public HashTable() {
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    int size() {
        return numItems;
    }

    boolean isEmpty() {
        return numItems == 0;
    }

    void remove(K k) {
        if (k == null ) return;

        int hashedKey = hash(k);

        while (!keys[hashedKey].equals(k)) {
            hashedKey = (hashedKey + 1) % capacity;
        }

        keys[hashedKey] = null;
        values[hashedKey] = null;

        numItems--;

        if (numItems <= capacity/3) {
            resize(capacity/2);
        }
    }
    void put(K k, V v) {
        if (k == null || v == null) return;

        //load factor
        if (numItems >= capacity * 0.75) {
            resize(2 * capacity);
        }

        int hashedKey = hash(k);

        while (keys[hashedKey] != null) {

            if (keys[hashedKey].equals(k)) {
                values[hashedKey] = v;
                return;
            }
            hashedKey = (hashedKey + 1) % capacity;
        }
        keys[hashedKey] = k;
        values[hashedKey] = v;
    }

    private void resize(int newCapacity) {
        HashTable<K, V> newTable = new HashTable<>(newCapacity);
        for (int j = 0; j < capacity; j++) {
            if (keys[j] != null) {
                newTable.put(keys[j], values[j]);
            }
        }
        keys = newTable.keys;
        values = newTable.values;
        capacity = newTable.capacity;

    }

    V get(K key) {
        if (key == null) return null;
        int hashedKey = hash(key);

        while (keys[hashedKey] != null) {
            if (keys[hashedKey].equals(key)) {
                return values[hashedKey];
            }
        }

        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }
}
