package br.com.mhbp.datastructure.hashtable.linearprobing;

public class HashTable {

    HashItem[] hashTable;
    static final  int SIZE = 10;

    public HashTable( ) {
        this.hashTable = new HashItem[SIZE];
    }


    int get(int key) {
        int hashedKey = hashFunction(key);
        while (hashTable[hashedKey] != null && hashTable[hashedKey].key != key) {
            hashedKey = hashFunction((hashedKey + 1) % 10);
        }

        if (hashTable[hashedKey] == null)
            return -1;
        else
            return hashTable[hashedKey].value;
    }

    void put(int key, int value) {
        int hashedKey = hashFunction(key);

        while (hashTable[hashedKey] != null) {
            hashedKey = hashFunction((hashedKey + 1) % 10);
        }

        hashTable[hashedKey] = new HashItem(key, value);
    }

    int hashFunction(int key) {
        return key % SIZE;
    }
}
