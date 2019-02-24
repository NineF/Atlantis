package com.bulingbuu.problem.linkedlist;

/**
 * @author bulingbuu
 * @date 19-2-24 下午7:16
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node1 = new ListNode(8);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        node1.next = node10;
        node10.next = node11;

        ListNode node2 = new ListNode(2);
        ListNode node20 = new ListNode(6);
        ListNode node21 = new ListNode(4);
//        node2.next = node20;
//        node20.next = node21;

        ListNode result = addTwoNumbers.addTwoNumbers(node1, node2);
        System.out.println(result);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int x = 0;
        while (l1 != null || l2 != null) {
            int i1 = 0;
            int i2 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }

            int k = i1 + i2 + x;
            x = 0;
            if (k > 9) {
                x = 1;
                k %= 10;
            }

            ListNode node1 = new ListNode(k);
            node.next = node1;
            node = node1;
        }
        if (x != 0) {
            ListNode node1 = new ListNode(x);
            node.next = node1;
        }

        return head.next;
    }
}
