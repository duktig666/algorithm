package leetcode.codetop;

import java.util.PriorityQueue;

/**
 * description:https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author RenShiWei
 * Date: 2021/11/29 16:17
 **/
public class 合并K个升序链表_23 {

    public static class ListNode {
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
     * 思路：
     * 1. 虚拟头结点，方便返回结果；res = dummy
     * 2. 优先队列添加所有链表头结点（小根堆）
     * 3. 当优先队列不为null，每次取出队首元素（最小节点），连接到结果链表上
     * 4. 将连接到res的下一个节点（不为null时），添加到优先队列中
     * 5. 返回 dummy.next
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(- 1);
        // 在使用一个变量，用来进行链表向后遍历的操作，dummy方便最后结果的返回
        ListNode res = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        // 利用优先队列，维护一个二叉堆（堆排），计算时每次取出最小的节点
        for (ListNode head : lists) {
            // 当前链表头结点不为null，加入优先队列当中
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        // 每次将最小节点添加到 res 的末尾
        while (! priorityQueue.isEmpty()) {
            ListNode minNode = priorityQueue.poll();
            res.next = minNode;
            // 当前最小元素节点 下一个元素 不为null时，继续向优先队列添加
            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }
            // 结果链表，后移
            res = res.next;
        }
        return dummy.next;
    }

}

