package leetcode.codetop;

/**
 * description: 反转链表 @see https://leetcode-cn.com/problems/reverse-linked-list/
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author RenShiWei
 * Date: 2021/8/30 21:30
 **/
public class 反转链表_206 {

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
     * 迭代实现反转链表
     */
    public ListNode reverseList(ListNode head) {
        //临时保存上一节点
        ListNode pre = null, cur = head, nextTemp = null;
        while (cur != null) {
            //临时节点，用于存储下一个节点，当指针反转后，还能指向写一个节点
            nextTemp = cur.next;
            // 反转指针
            cur.next = pre;

            // pre移动到当前节点，用于下一个循环进行比对
            pre = cur;
            //头结点指向下一个节点，并进入下一个循环
            cur = nextTemp;
        }
        return pre;
    }

    /**
     * 递归实现链表反转
     */
    public ListNode reverse(ListNode head) {
        //当前节点为null，或者前一个节点为null，结束递归（递归过程需要判断下一个节点，所以也要判断）
        if (head == null || head.next == null) {
            return head;
        }
        //进入递归，返回值相当于当前节点
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 后驱节点
    ListNode successor = null;

    /**
     * 将链表的前 n 个节点反转（n <= 链表⻓度）
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后⾯的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 给⼀个索引区间 [m,n]（索引从 1 开始），仅仅反转区间中的链表元素
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}

