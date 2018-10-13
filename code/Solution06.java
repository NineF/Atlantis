
/**
 * @author bulingbuu
 * @date 18-10-13 上午9:36
 * 判断链表是否为回文
 *
 * 采用快慢指针
 */
public class Solution06 {

    public static void main(String[] args) {

        LinkNode node5 = new LinkNode(1, null);
        LinkNode node4 = new LinkNode(2, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(3, node3);
        LinkNode node1 = new LinkNode(2, node2);
        LinkNode head = new LinkNode(1, node1);
        System.out.println(isHw(head));

    }

    public static boolean isHw(LinkNode head) {
        if (head == null) {
            return false;
        }
        LinkNode prev = null;
        LinkNode fast = head;
        LinkNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            LinkNode temp = prev;
            prev = slow;
            slow = slow.next;
            prev.next = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (slow.data != prev.data) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }


    static class LinkNode {
        public int data;
        public LinkNode next;

        public LinkNode(int data, LinkNode next) {
            this.data = data;
            this.next = next;
        }
    }
}

