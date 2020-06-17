package br.com.mhbp.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_now {

    Node head, tail;
    int capacity;
    int totalElements;
    private Map<Integer, Node> map = new HashMap<>();


    public LRUCache_now(int capacity) {

        this.capacity = capacity;
        head = new Node();
        tail = new Node();
    }


    public void put(int key, int value) {

        Node node = map.get(key);


        if (node == null) {
            Node newNode =  new Node(key, value);
            map.put(key, newNode);
            totalElements++;


        } else {

        }
    }


    static class Node {
        int key;
        int value;
        Node prev, next;

        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}
