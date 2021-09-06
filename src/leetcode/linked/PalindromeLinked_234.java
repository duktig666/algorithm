package leetcode.linked;

/**
 * description:回文链表 @see https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author RenShiWei
 * Date: 2021/9/6 17:59
 **/
public class PalindromeLinked_234 {

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
     * 判断链表是否为回文链表
     * 1. 寻找链表中点（如果是奇数，第二个节点为目标节点）
     * 2. 反转前边的链表
     * 3. 如果后半部分的链表是奇数（去掉后半部分的第一个节点）
     * 4. 依次对比元素，判断是否为回文链表
     */
    public boolean isPalindrome(ListNode head) {
        // 如果链表为空 或者 只有一个元素，证明是回文链表
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        //寻找链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转链表
        //pre用来保存先前结点
        ListNode pre = null;
        //next用来做临时变量
        ListNode temp = null;
        while (head != slow) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        //如果是奇数节点，则去掉后半部分的第一个节点
        if (fast != null) {
            slow = slow.next;
        }
        //一次判断
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}

