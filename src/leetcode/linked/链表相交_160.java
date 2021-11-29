package leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * description: 链表相交 @see https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author RenShiWei
 * Date: 2021/9/17 15:39
 **/
public class 链表相交_160 {

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
     * 得到链表相交的起点节点，若未相交返回null
     * 思路二：双指针
     * 时间复杂度：O(a+b) 空间复杂度：O(1)
     * <p>
     * 循环中的代码可以写为：
     * // p1 ⾛⼀步，如果⾛到 A 链表末尾，转到 B 链表
     * if (p1 == null) {
     * p1 = headB;
     * } else {
     * p1 = p1.next;
     * }
     * // p2 ⾛⼀步，如果⾛到 B 链表末尾，转到 A 链表
     * if (p2 == null) {
     * p2 = headA;
     * } else {
     * p2 = p2.next;
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    /**
     * 得到链表相交的起点节点，若未相交返回null
     * 思路一：利用HashSet
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    public ListNode getIntersectionNodeByHashSet(ListNode headA, ListNode headB) {
        // 边界判断
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // 存在A相同的节点，即说明相交
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}

