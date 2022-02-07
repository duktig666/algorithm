package leetcode.codetop;

import common.ListNode;

/**
 * description: https://leetcode-cn.com/problems/reorder-list/
 * <p>
 * 找中点+反转后半部分+合并前后两部分
 *
 * @author RenShiWei
 * Date: 2022/2/7 17:28
 **/
public class codetop34_重排链表_143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 寻找中点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        // 断开总段后半部分
        mid.next = null;
        // 反转后半段
        l2 = reverseList(l2);
        // 合并链表
        mergeList(l1, l2);
    }

    /**
     * 寻找链表的中点
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 合并链表
     */
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }

}

