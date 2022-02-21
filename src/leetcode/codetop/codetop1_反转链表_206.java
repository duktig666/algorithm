package leetcode.codetop;

import common.ListNode;

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
public class codetop1_反转链表_206 {


    /**
     * 迭代实现反转链表
     */
    public ListNode reverseList(ListNode head) {
        //临时保存上一节点
        ListNode pre = null, cur = head, nextTemp = null;
        while (cur != null) {
            //临时节点，用于存储下一个节点，当指针反转后，还能指向下一个节点
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
     * 递归实现
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

    /**
     * 迭代实现
     * 给⼀个索引区间 [m,n]（索引从 1 开始），仅仅反转区间中的链表元素
     * 思路：
     * 1. pre 寻找到 left 的前一个元素
     * 2. 遍历，每次将元素移动到最前边（移动n-1次）
     * <p>
     * 每遍历到一个节点，让这个新节点来到反转部分的起始位置
     *
     * <p>
     * 指针含义：
     * cur：指向待反转区域的第一个节点 left；
     * nextTemp：永远指向 cur 的下一个节点，循环过程中，cur 变化以后 nextTemp 会变化；
     * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     */
    public ListNode reverseBetweenLoop(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(- 1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // pre 找到 left 的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode nextTemp;
        for (int i = 0; i < right - left; i++) {
            nextTemp = cur.next;
            cur.next = nextTemp.next;
            nextTemp.next = pre.next;
            pre.next = nextTemp;
        }
        return dummyNode.next;
    }


}

