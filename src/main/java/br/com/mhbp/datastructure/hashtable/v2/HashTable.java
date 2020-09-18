package br.com.mhbp.datastructure.hashtable.v2;

public class HashTable {
    HashItem[] items;

    public HashTable() {
        items = new HashItem[HashItem.TABLE_SIZE];
    }

    void put (int key, int value) {
        int hashedKey = hash(key);
        if (items[hashedKey] == null) {
            items[hashedKey] = new HashItem(key, value);
        } else {
            HashItem item = items[hashedKey];

            while (item.next != null) item = item.next;
                item.next = new HashItem(key, value);
        }
    }

    int get(int key) {
        int hashedKey = hash(key);
        if (items[hashedKey] == null) throw new IllegalArgumentException("there is no key: " + key);

        HashItem item = items[hashedKey];
        while (item != null) {
            if (item.key == key) return item.value;
        }

        throw new IllegalArgumentException("there is no key: " + key);
    }
    int hash(int key) {
        return key % HashItem.TABLE_SIZE;
    }
}
