package br.com.mhbp.datastructure.hashtable.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity = 4;
    int size;
    Map<Integer, Node> map;
    DoublyLinkedList dll;

    public LRUCache() {
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    void put(Integer key, String data) {

        if (map.containsKey(key)) { //over capacity
            Node node = map.get(key);
            node.data = data;
            update(node);

        } else {
            Node node = new Node(data);

            if (size < capacity) {
                size++;
                add(node);
            } else {
                removeTail();
                add(node);
            }
        }

    }

    Node get(Integer key) {
        Node n = map.get(key);
        if (n != null) update(n);
        return n;
    }

    private void add(Node node) {
        node.next = dll.head;

        if (dll.head != null)
            dll.head.previous = node;

        dll.head = node;

        if (dll.tail == null)
            dll.tail = node;
        map.put(node.id, node);
    }

    private void removeTail() {
        Node tail = dll.tail;
        dll.tail = tail.previous;
        map.remove(tail.id);
        dll.tail.next = null;
        tail = null;
    }

    private void update(Node node) {
        Node next = node.next;
        Node previous = node.previous;

        if (previous != null)
            previous.next = next;

        if (next != null)
            next.previous = previous;

        node.next = dll.head;
        dll.head = node;
    }
}
