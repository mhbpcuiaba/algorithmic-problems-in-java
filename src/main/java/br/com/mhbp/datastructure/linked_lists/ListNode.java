package br.com.mhbp.datastructure.linked_lists;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(){}
    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public static <T> ListNode<T> search(ListNode<T> list, T element) {

        while(list != null && !list.data.equals(element)) list = list.next;

        return list;
    }

    public static <T> void insertAfter(ListNode<T> list, T newData) {
    }

    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> l1, ListNode<Integer> l2) {

        Integer l1Length = length(l1);
        Integer l2Length = length(l2);

        if(l1Length > l2Length) {
            l1 = advanceListByK(l1Length -l2Length, l1);
        } else {
            l2 = advanceListByK(l2Length -l1Length, l2);
        }

        while (l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }


    public static ListNode<Integer> removeKthLast(ListNode<Integer> l, int k) {
        ListNode<Integer> dummyHead = new ListNode<>(0, l);
        ListNode<Integer> first = dummyHead.next;

        while (k-- >0) first = first.next;

        ListNode<Integer> second = dummyHead;

        while (first != null) {
            second = second.next;
            first = first.next;
        }

        // second.next is the node to be remove
        second.next = second.next.next;
        return dummyHead.next;
    }
    public static ListNode<Integer> overlappingWithCycleLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> root1 = hasCycle(l1);
        ListNode<Integer> root2 = hasCycle(l2);

        if (root1 == null && root2 == null) {
            return overlappingNoCycleLists(root1, root2);
        } else if(root1 != null && root2 != null || root1 == null && root2 != null) {
            return null;
        }

        //in this case both have cycle

        ListNode<Integer> tmp = root1;
        do {
            tmp = tmp.next;
        } while (tmp != root1 && tmp != root2);

        return tmp == root1 ? root1 : null;
    }

    private static int distance(ListNode<Integer> l1, ListNode<Integer> l2) {

        int count = 0;

        while (l1 != l2) {
            l1 = l1.next;
            count++;
        }

        return count;
    }
    private static ListNode<Integer> advanceListByK(int timesToAdvance, ListNode<Integer> node) {
        while (timesToAdvance-- > 0) node = node.next;
        return node;
    }

    private static Integer length(ListNode<Integer> head) {
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { //there is a cycle

                int cycleLength = 0;

                do {
                    cycleLength++;
                    fast = fast.next;
                } while (slow != fast);

                ListNode<Integer> startOfCycle = head;

                while (cycleLength-- > 0) startOfCycle = startOfCycle.next;

                ListNode<Integer> iter = head;

                /*
                a ieia aki eh q como um ponteiro esta na frente do outro pelo tamanho do ciclo
                entao basta ir avanvancando ateh eles se encontrarem
                 */
                while (iter != startOfCycle) {
                    iter = iter.next;
                    startOfCycle = startOfCycle.next;
                }

                return startOfCycle;
            }

        }
        return null;
    }
    public static ListNode<Integer> reverseSubList(ListNode<Integer> list, int start, int end) {
        ListNode<Integer> dummyHead = new ListNode<>(0, list);

        int count = 1;
        while (count++ < start) list = list.next;

        ListNode<Integer> subListIter = list.next;

        while (start < end) {
            //
            ListNode<Integer> tmp = subListIter.next;
            subListIter.next = tmp.next;

            //
            tmp.next = list.next;
            list.next = tmp;


        }
        //now list is pointing to node
        return null;
    }
    public static ListNode<Integer>  mergeTwoSortedListNode(ListNode<Integer> l1, ListNode<Integer> l2) {

        //the trick is these two pointers!!!!!
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;

        while (l1 != null && l2 != null) {

            if (l1.data.compareTo(l2.data) <= 0) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;

            }

            current = current.next;
        }


        current.next = l1 != null? l1:l2;
        return dummyHead.next;
    }

    public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> root, int times) {

        if (root == null || root.next == null) return root;

        ListNode<Integer> curr = root;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }


        ListNode<Integer> tail = curr;
        int shitfSize = count % times;

        if (shitfSize == 0) return root;

        curr = root;
        ListNode<Integer> preCurr = null;
        tail.next = root;
        while (shitfSize-- > 0) {
            preCurr = curr;
            curr = curr.next;
        }

        preCurr.next = null;

        return curr;
    }

    public static ListNode<Integer> evenOddMerge(ListNode<Integer> root) {
        ListNode<Integer> oddsFakeHead = new ListNode<Integer>();
        ListNode<Integer> oddsTail = oddsFakeHead;
        ListNode<Integer> fakeHead = new ListNode<Integer>();
        fakeHead.next = root;
        ListNode<Integer> iter = fakeHead;

        while (iter.next != null) {

            if (iter.next.data % 2 == 1) {
                oddsTail.next = iter.next;
                oddsTail = oddsTail.next;//advance odds
                iter.next = iter.next.next;
            }

            iter = iter.next;
        }
        iter.next = oddsFakeHead.next;
        oddsTail.next = null;
        oddsFakeHead.next = null;

        return root;
    }

    public static boolean isListPalindromic(ListNode<Integer> root) {
        ListNode<Integer> fast = root, slow = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode<Integer> firsHalfIter = root;
        ListNode<Integer> secondHalfIter = reverseList(slow);

        while (firsHalfIter != null && secondHalfIter != null) {

            if (!firsHalfIter.data.equals(secondHalfIter.data)) return false;
            firsHalfIter = firsHalfIter.next;
            secondHalfIter = secondHalfIter.next;
        }
        return true;
    }

    private static ListNode<Integer> reverseList(ListNode<Integer> root) {
        if ( root == null || root.next == null) return root;
        ListNode<Integer> iter = root;
        ListNode<Integer> dummieHead = new ListNode<>();
        dummieHead.next = iter;
        ListNode<Integer> prev = dummieHead;
        ListNode<Integer> tmp;
        while (iter != null) {
            tmp = iter.next;
            iter.next = prev;
            prev = iter;
            iter = tmp;
        }
        root.next = null;
        return prev;
    }


    public static ListNode<Integer> listPivoting(ListNode<Integer> list, int k) {
        ListNode<Integer> lessThan = new ListNode<Integer>();
        ListNode<Integer> greatThan = new ListNode<Integer>();
        ListNode<Integer> greatThanHead = greatThan;
        ListNode<Integer> iter = list;


        while (iter != null) {

            if (iter.data > k ) { //even
                greatThan.next = iter;
                greatThan = greatThan.next;
                iter = iter.next;
            } else if (iter.data < k )  { //odd
                lessThan.next = iter;
                lessThan = lessThan.next;
                iter = iter.next;
            } else {
                ListNode<Integer> tmp = greatThanHead.next;
                greatThanHead.next = iter;
                tmp.next =  iter.next;
                iter.next = tmp;
                iter = tmp.next;
            }

        }

        lessThan.next = greatThanHead.next;
        greatThanHead.next = null;
        return null;
    }

    public static ListNode<Integer> listPivoting(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<Integer>();
        ListNode<Integer> placeIter = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            //calc
            int l1Int = l1.data != null ? l1.data:0;
            int l2Int = l2.data != null ? l2.data:0;
            int val = carry + l1Int + l2Int;

            //updates
            carry = val/10;
            placeIter.next = new ListNode<>(val % 10, null);

            //advance pointers
            placeIter = placeIter.next;
            l1 = l1 == null? null:l1.next;
            l2 = l2 == null? null:l2.next;
        }

        return dummyHead.next;
    }
}
