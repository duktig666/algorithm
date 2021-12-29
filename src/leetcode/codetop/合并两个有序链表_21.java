package leetcode.codetop;

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

    /**
     * 思路：
     * 1. 设置虚拟头结点（方便返回头结点），设置新的节点p 指向虚拟头结点
     * 2. 循环遍历，谁的元素小指向谁
     * 3. 最后，另一条链可能还存在节点，续上
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点作用：并不知道谁的节点小，方便计算
        ListNode dummy = new ListNode(- 1), p = dummy;
        while (list1 != null && list2 != null) {
            // 谁的元素小，p指向谁，保持有序
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            // p不断前进
            p = p.next;
        }
        // 另一条链可能还存在节点
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        // 去掉虚拟头结点
        return dummy.next;
    }

}

