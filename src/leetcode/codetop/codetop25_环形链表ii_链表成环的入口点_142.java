package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/c32eOV/
 *
 * @author RenShiWei
 * Date: 2021/11/29 20:44
 **/
public class codetop25_环形链表ii_链表成环的入口点_142 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 找到环的入口节点
     */
    public ListNode detectCycle(ListNode head) {
        // 先找出环中的相遇节点
        ListNode meetingNode = getMeetingNode(head);
        // 没有环，返回null
        if (meetingNode == null) {
            return null;
        }
        // p1 指向快慢指针相遇的节点
        ListNode p1 = meetingNode;
        // p2 指向头节点
        ListNode p2 = head;
        // p1和p2以相同的速度向前移动，当p2指向环的入口节点时，p1已经围绕着环走了n圈又回到了入口节点。
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //返回入口节点
        return p1;
    }

    /**
     * 找到环中相遇的节点，不存在环返回null
     */
    private ListNode getMeetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }


}

