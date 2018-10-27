package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-27 上午9:59
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Problem21 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(14, null);
        ListNode node3 = new ListNode(12, node4);
        ListNode node2 = new ListNode(7, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode head = new ListNode(1, node1);


        ListNode node40 = new ListNode(19, null);
        ListNode node30 = new ListNode(7, node40);
        ListNode node20 = new ListNode(6, node30);
        ListNode node10 = new ListNode(2, node20);
        ListNode head0 = new ListNode(1, node10);

        ListNode.outNode(mergeTwoLists1(head, head0));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head, tail;

        if (l1.val < l2.val) {
            head = tail = l1;
            l1 = l1.next;
        } else {
            head = tail = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;

                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head;
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists1(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists1(l1, l2.next);
        }
        return mergeHead;
    }
}
