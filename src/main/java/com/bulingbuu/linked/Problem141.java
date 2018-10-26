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
    }

    public static boolean hasCycle(ListNode head) {
        return false;
    }
}
