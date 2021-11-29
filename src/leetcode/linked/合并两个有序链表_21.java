package leetcode.linked;

/**
 * description:https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author RenShiWei
 * Date: 2021/11/27 21:19
 **/
public class 合并两个有序链表_21 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点作用：并不知道谁的节点小，方便计算
        ListNode dummy = new ListNode(- 1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            // 谁的元素小，p指向谁，保持有序
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p不断前进
            p = p.next;
        }
        // 另一条链可能还存在节点
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        // 去掉虚拟头结点
        return dummy.next;
    }

}

