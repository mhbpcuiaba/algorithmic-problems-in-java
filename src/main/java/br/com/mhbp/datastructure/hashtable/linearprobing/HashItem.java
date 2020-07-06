package br.com.mhbp.datastructure.hashtable.linearprobing;

public class HashItem {

    static final int TABLE_SIZE = 17;
    int key, value;

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
