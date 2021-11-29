package leetcode.linked;

/**
 * description:https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author RenShiWei
 * Date: 2021/11/29 17:25
 **/
public class 删除链表的倒数第N个结点_19 {

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
     * 寻找链表倒数第 N 个节点
     */
    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 寻找链表倒数第 N 个节点
     * 加入虚拟头结点，防止删除时出现空指针。
     * eg：⽐如说链表总共有 5 个节点，题⽬就让你删除倒数第 5 个节点，也就是第⼀个节点，
     * 那按照算法逻辑，应该⾸先找到倒数第 6 个节点。但第⼀个节点前⾯已经没有节点了，这就会出错。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(- 1);
        dummy.next = head;
        ListNode pre = findNthFromEnd(dummy, n + 1);
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 删除链表倒数第 N 个节点 （出现空指针异常的情况）
     */
    public ListNode removeNthFromEndTmp(ListNode head, int n) {
        if (head == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(- 1);
        dummy.next = head;
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode del = p2.next;
        p2.next = p2.next.next;
        del.next = null;
        return dummy.next;
    }

}

