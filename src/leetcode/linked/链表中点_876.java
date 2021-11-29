package leetcode.linked;

/**
 * description: 链表的中间结点 @see https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author RenShiWei
 * Date: 2021/8/31 9:39
 **/
public class 链表中点_876 {

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
     * 快慢指针寻找链表中点
     * 快指针是慢指针的2倍，快指针为空或者快指针的下一个节点为空，证明慢指针找到了链表的中点
     * (两个中点的情况，选取第二个)
     * <p>
     * 另一种思路：单指针扫描（不如快慢指针）
     * 单指针扫描第一次统计有N个节点
     * 第二次扫描到N/2时返回中点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 辅助数组实现： 中点即为 N / 2
     * 缺点：需要利用辅助空间，不确定节点数量，根据题意申请固定的100个空间有些浪费
     */
    public ListNode middleNode2(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int t = 0;
        while (head != null) {
            nodes[t++] = head;
            head = head.next;
        }
        return nodes[t / 2];
    }

}

