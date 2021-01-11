package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.fast_slow_pointers;

public class LinkedListCycle {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
        System.out.println("LinkedList cycle size: " + calculateLengthCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
        System.out.println("LinkedList cycle size: " + calculateLengthCycle(head));
    }

    public static boolean hasCycle(ListNode head) {

        ListNode faster = head.next;
        ListNode slower = head;

//        ListNode startCyle
        while (faster != null && faster.next != null) {

            if ( faster == slower) {
                return true;
            }

            slower = slower.next;
            faster = faster.next.next;
        }
        return false;
    }

    public static ListNode findCycleStart(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        int k = calculateLengthCycle(head);

        for (int i = 1; i <= k; i++) {
            p2 = p2.next;
        }

        while (p2 != p1) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    public static int calculateLengthCycle(ListNode head) {

        ListNode faster = head.next;
        ListNode slower = head;

        ListNode startCycle = null;
        while (faster != null && faster.next != null) {

            if ( faster == slower) {
                startCycle = slower;
                break;
            }

            slower = slower.next;
            faster = faster.next.next;
        }

        if (startCycle == null) return 0;

        int length = 1;
        startCycle = startCycle.next;
        while (startCycle != slower) {
            length++;
            startCycle = startCycle.next;
        }
        return length;
    }


}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}