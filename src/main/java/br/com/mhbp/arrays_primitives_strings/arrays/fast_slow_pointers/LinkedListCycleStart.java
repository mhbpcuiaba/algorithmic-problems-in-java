package br.com.mhbp.arrays_primitives_strings.arrays.fast_slow_pointers;

public class LinkedListCycleStart {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }

    public static Node findCycleStart(Node head) {
        Node p1 = head, p2 = head;

        return head;
    }
}

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}