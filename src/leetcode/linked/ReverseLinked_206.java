package leetcode.linked;

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
public class ReverseLinked_206 {

    static class ListNode {
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
        ListNode pre = null;
        while (head != null) {
            //临时节点，用于存储下一个节点，当指针反转后，还能指向写一个节点
            ListNode temp = head.next;
            // 反转指针
            head.next = pre;

            // pre移动到当前节点，用于下一个循环进行比对
            pre = head;
            //头结点指向下一个节点，并进入下一个循环
            head = temp;
        }
        return pre;
    }

    /**
     * 递归实现链表反转
     */
    public ListNode reverse(ListNode head) {
        //当前节点为null，或者写一个节点为null，结束递归（递归过程需要判断下一个节点，所以也要判断）
        if (head == null || head.next == null) {
            return head;
        }
        /*
            临时节点，用于存储下一个节点，当指针反转后，还能指向写一个节点
            此时head=3结点，temp=3结点.next(实际上是4结点)
            执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点
         */
        ListNode temp = head.next;
        //进入递归，返回值相当于当前节点
        ListNode newNode = reverse(head.next);
        /*
           弹栈过程:
            程序继续执行 temp.next = head就相当于4->3 （temp相当于下一个节点，temp.next相当于下一个节点的指针；即下一个节点指向当前节点，实现反转）
            head.next = null 即把3结点指向4结点的指针断掉
            返回新链表的头结点newHead
         */
        temp.next = head;
        head.next = null;
        return newNode;
    }

}

