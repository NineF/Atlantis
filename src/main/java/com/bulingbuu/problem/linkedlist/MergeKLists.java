package com.bulingbuu.problem.linkedlist;

/**
 * @author bulingbuu
 * @date 19-2-20 上午11:17
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode node0 = new ListNode(1);
        ListNode node00 = new ListNode(4);
        ListNode node01 = new ListNode(5);
        node0.next = node00;
        node00.next = node01;

        ListNode node1 = new ListNode(2);
        ListNode node10 = new ListNode(6);
        node1.next = node10;

        ListNode node2=new ListNode(1);
        ListNode node20=new ListNode(3);
        ListNode node21=new ListNode(4);
        node2.next=node20;
        node20.next=node21;

        ListNode[] listNodes = new ListNode[0];
//        listNodes[0] = node0;
//        listNodes[1]=node2;
//        listNodes[2] = node1;

        ListNode listNode = mergeKLists.mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /**
     * 多路并归合并
     *
     * @param lists
     *
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;

        while (k > 1) {
            for (int i = 0; i < k / 2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i + (k + 1) / 2]);
            }
            k = (k + 1) / 2;
        }
        return lists[0];
    }

    /**
     * 递归合并两个链表
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = merge2Lists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = merge2Lists(l1, l2.next);
        }
        return mergeHead;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        }
        if (list2 == null) {
            node.next = list1;
        }
        return root.next;
    }

}

