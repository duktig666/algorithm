package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author RenShiWei
 * Date: 2021/12/25 10:34
 **/
public class codetop5_K个一组翻转链表_25 {

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
     * 思路：
     * 1. 根据 k 找到 b节点
     * 2. 翻转 [a,b) 的节点
     * 3. 递归翻转后将链表连接起来
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 迭代实现反转链表（翻转 head，b）
     */
    public ListNode reverse(ListNode head, ListNode b) {
        //临时保存上一节点
        ListNode pre = null, cur = head;
        while (cur != b) {
            //临时节点，用于存储下一个节点，当指针反转后，还能指向写一个节点
            ListNode temp = cur.next;
            // 反转指针
            cur.next = pre;

            // pre移动到当前节点，用于下一个循环进行比对
            pre = cur;
            //头结点指向下一个节点，并进入下一个循环
            cur = temp;
        }
        return pre;
    }

}

