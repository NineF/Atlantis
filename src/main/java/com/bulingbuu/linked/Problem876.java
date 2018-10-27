package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-27 下午4:04
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class Problem876 {

    public static void main(String[] args) {
//        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode.outNode(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
