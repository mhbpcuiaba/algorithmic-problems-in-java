package br.com.mhbp.datastructure.stack.and.queue;

import java.util.ArrayDeque;

public class StacksExample {
    static class ListNode {
        int val;
        ListNode next;
    }
    public static void printLinkedListInReverseOrder(ListNode head) {
        ArrayDeque<Integer> nodes = new ArrayDeque<>();

        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }


        while (!nodes.isEmpty()) {
            nodes.poll();
            System.out.println(nodes.pop());
        }
    }
}
