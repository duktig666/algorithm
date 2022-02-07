package common;

/**
 * description:链表的通用节点
 *
 * @author RenShiWei
 * Date: 2022/2/7 17:33
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

