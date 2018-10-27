package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-27 下午2:54
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class Problem19 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, null);

        ListNode.outNode(removeNthFromEnd(head, 1));
    }

    /**
     * 这个采用了一个哨兵节点,用来处理边界情况
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tmp = dummy, node = dummy;

        while (n > -1) {
            node = node.next;
            n--;
        }

        while (node != null) {
            node = node.next;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return dummy.next;
    }

}
