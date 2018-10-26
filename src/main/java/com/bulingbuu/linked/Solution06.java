package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-26 下午7:02
 * 判断链表是否为回文
 * <p>
 * 采用快慢指针
 */
public class Solution06 {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(1, null);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        System.out.println(isHw(head));

    }

    public static boolean isHw(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = prev;
            prev = slow;
            slow = slow.next;
            prev.next = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }


}
