package leetcode.linked;

/**
 * description:单链表是否有环 @see https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 思路一：每遍历一个新的节点，就从头结点重新遍历之前的节点，判断是否存在相同的节点ID，若遍历两次相同的节点ID，则证明有环
 * 思路二：利用HashSet，遍历存储节点ID，存储重复时，证明有环
 * 思路三：快慢指针。相交则说明链表成环
 *
 * @author RenShiWei
 * Date: 2021/9/6 20:43
 **/
public class 单链表是否有环_141 {

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
     * 快慢指针判断链表是否成环
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}

