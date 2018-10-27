package com.bulingbuu.linked;

/**
 * @author bulingbuu
 * @date 18-10-26 下午6:37
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void outNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
