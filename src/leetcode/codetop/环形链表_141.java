package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author RenShiWei
 * Date: 2021/12/14 21:06
 **/
public class 环形链表_141 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：
     * 1. 链表相关的题主要是依靠 【双指针】 来解题，重点是找到双指针对应的策略
     * 2. 是否成环，快指针走两步，慢指针走一步，如果两个指针相遇，说明成环
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}

