package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-26 下午6:36
 * <p>
 * Reverse a singly linked list.
 */
public class Problem206 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        ListNode.outNode(head);
        ListNode.outNode(reverseList(head));
    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, tmp;

        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }


}
