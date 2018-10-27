package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-26 下午6:56
 * Given a linked list, determine if it has a cycle in it.
 */
public class Problem141 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        node4.next = head;
        System.out.println(hasCycle2(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        while (slow != null) {
            slow = slow.next;
            if (slow == head) {
                return true;
            }
        }

        return false;
    }


    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
