package br.com.mhbp.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int maxCapacity;
    private int totalItemsInCache;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.next = head;
    }

    //when we get a value by key it means get de value from the head of cirluar list indise the bucket found it. It should be the most recently accesd elment in the circular list storaged into the
    public Integer get(int key) {
        Node node = map.get(key);

        if (node == null)
            return null;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        //there is no colision
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;

            if (totalItemsInCache > maxCapacity) {
               removeLRUEntry();
            }

        } else {
            node.value = value;//If exists, we override the value.
            moveToHead(node);
        }

    }

    private void removeLRUEntry() {
        Node tail = popTail();
        map.remove(tail.key);
    }

    private Node popTail() {
        Node tailItem = tail.prev;
        removeFromList(tailItem);// i thought removeFromList(tail);
        return tailItem;
    }

    //i think it should named addToBack, at least for now
    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;


    }

    private void removeFromList(Node node) {

        Node next = node.next;
        Node prev = node.prev;

        next.prev = next;
        next.next = prev;
    }

    private void moveToHead(Node node) {
       removeFromList(node);
        addToFront(node);
    }

    static class Node {
        Node prev, next;
        Integer key, value;
    }
}
