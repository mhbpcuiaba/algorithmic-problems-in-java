package br.com.mhbp.datastructure.hashtable;

import java.util.ArrayList;

public class Map<K, V> {

    private ArrayList<Node<K, V>> bucketArray;
    private int numBuckets;
    private int size;

    public Map() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % numBuckets;
    }

    public V remove(K key) {
        int indexNodeToBeRemoved = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(indexNodeToBeRemoved);

        Node<K, V> prev = null;
        while (head != null) {

            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;// it was not found it!!!

        if (prev != null) {// is not a first element into the bucket, it is the head
            prev.next = head.next;
            head.next = null;
        } else {
            bucketArray.set(indexNodeToBeRemoved, head.next); // how the element beeing removed is the first so it 'next' node should be promoted to be the head
        }
        size--;
        return head.value;
    }

    public V get(K key) {
        int indexNodeToBeRemoved = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(indexNodeToBeRemoved);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);


        while(head != null) {

            if(head.key.equals(key)) { //in this case the element already exists so we update its value
                head.value = value;
                return;
            }
        }

        //since ti is a new element
        size++;
        head = bucketArray.get(bucketIndex);
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then double hash table size
        if ( (1.0*size)/numBuckets >= 0.7) {
            ArrayList<Node<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (Node<K, V> headNode : temp) {

                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }


    }

}