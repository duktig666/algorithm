package leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * description: 链表相交 @see https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author RenShiWei
 * Date: 2021/9/17 15:39
 **/
public class LinkedIntersection_160 {

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
     * 假设链表 A 的节点数为 a，链表 B 的节点数为 b，两链表的公共尾部节点数为 c ，第一个公共节点为 c1
     * 让指针 PA 和 pB 分别指向链表 A 和链表 B 的头结点，之后两个指针分别以步幅为 1 的速度向链表的尾部遍历。
     * <p>
     * 当指针 pA 遍历到链表 A 的尾节点时，此时指针 pA 走了 a 个节点，将指针 pA 指向链表 B 的头部，继续向后遍历，直至走到 c1，此时指针 PA 总共走了 a + ( b - c ) 步。<br>
     * 当指针 pB 遍历到链表 B 的尾节点时，此时指针 pB 走了 b 个节点，将指针 pB 指向链表 A 的头部，继续向后遍历，直至走到 c1，此时指针 PB 总共走了 b + ( a - c ) 步。
     * <p>
     * 根据数学知识，a + ( b - c ) = b + ( a - c )   ，如果 c > 0，表明两链表有公共尾部， c1 存在，两两链表同时到达 c1；
     * 如果 c = 0，表明两链表没有公共尾部，指针 PA 和 pB都指向 NULL。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界判断
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;

        //指针 PA 和 指针 PB 不断向后遍历，直到找到相交点
        while (pA != pB) {
            // 指针 PA 一开始在链表 A 上遍历，当走到链表 A 的尾部即 null 时，跳转到链表 B 上
            pA = pA == null ? headB : pA.next;
            // 指针 PB 一开始在链表 B 上遍历，当走到链表 B 的尾部即 null 时，跳转到链表 A 上
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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

