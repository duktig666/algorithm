package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * @author RenShiWei
 * Date: 2021/12/16 10:10
 **/
public class 相交链表_160 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 思路：
     * 1. 寻找链表是否成环的思路是，快慢指针如果相遇，即说明成环
     * 2. 如果要寻找成环的入口（交点），存在最大的问题是，从两个链表头开始遍历，两个链表的长度不同，怎么也不会相交
     * 3. 所以，思路是 链表A：遍历完链表A，在遍历链表B 链表B：遍历完链表B，在遍历链表A。 这样即可相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}

