package datastructure.linked;

import org.junit.Test;

/**
 * description:单链表
 *
 * @author RenShiWei
 * Date: 2021/6/4 21:00
 **/
public class SingleLinkedList<E> {

    /**
     * 内部类：表示链表的节点
     */
    private static class Node<E> {
        /** 所存储的元素 */
        E e;

        /** 节点 */
        Node<E> next;

        /** 索引（算法题中的量，并不在数据中使用） */
        int val;

        Node(int x) { val = x; }

        Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /** 虚拟头结点 */
    private Node<E> dummyHead;

    /** 存储元素数量 */
    private int size;

    public SingleLinkedList() {
        dummyHead = new Node<>();
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return /
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return /
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     *
     * @param index 索引
     * @param e     要添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node<E> prev = dummyHead;
        //检索到index的位置
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*
          三步合并成一步（详情见注释）
                Node<E> node = new Node<E>(e);
                node.next = prev.next;
                prev.next = node;
        */
        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素e
     *
     * @param e /
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     *
     * @param e /
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的索引位置的元素
     *
     * @param index /
     * @return /
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node<E> cur = dummyHead.next;
        //如果index是0，不执行循环，直接返回第一个元素，所以cur直接指向第一个元素，即dummyHead.next
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return /
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return /
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     *
     * @param index /
     * @param e     /
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e /
     * @return /
     */
    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素, 返回删除的元素
     *
     * @param index /
     * @return /
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        //这里不是 dummyHead.next ,到时候需要删除prev的下一个元素
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> delNode = prev.next;
        //待删除的上一个元素的指针，指向待删除元素的下一个元素
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 从链表中删除第一个元素, 返回删除的元素
     *
     * @return /
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素, 返回删除的元素
     *
     * @return /
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     *
     * @param e /
     */
    public void removeElement(E e) {
        Node<E> prev = dummyHead;
        //找到待删除的上一个元素
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node<E> delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    /**
     * 寻找链表的中点（快慢指针）
     * 快指针是慢指针的2倍，快指针为空或者快指针的下一个节点为空，证明慢指针找到了链表的中点
     *
     * @param node /
     * @return /
     */
    public Node<E> findMidPoint(Node<E> node) {
        Node<E> fast = node.next.next;
        Node<E> slow = node.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //链表的中点
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 实现链表的反转（遍历法）
     * <p>
     * 思路：从前往后反转各个结点的指针域的指向。
     * 将当前节点cur的下一个节点 cur.getNext()缓存到temp后，然后更改当前节点指针指向上一结点pre。
     * 也就是说在反转当前结点指针指向前，先把当前结点的指针域用tmp临时保存，以便下一次使用。
     *
     * @param node 链表
     * @return 反转后的链表
     */
    public Node<E> reverseIteratively(Node<E> node) {
        if (dummyHead == null || dummyHead.next == null) {
            return null;
        }
        //pre用来保存先前结点
        Node<E> pre = null;
        //next用来做临时变量
        Node<E> temp = null;
        /*
            循环过程：
               在头结点node遍历的时候此时为1结点
                temp = 1结点.next(2结点)
                1结点.next = pre(null)
                pre = 1结点
                node = 2结点
                进行下一次循环node=2结点
                temp = 2结点.next(3结点)
                2结点.next=pre(1结点)=>即完成2->1
                pre = 2结点
                node = 3结点
                进行循环…
         */
        while (node != null) {
            temp = node.next;
            //反转指针指向
            node.next = pre;
            //指针向下移动
            pre = node;
            node = temp;
        }
        return pre;
    }

    /**
     * 实现链表的反转（递归法）
     * 递归实质上就是系统帮你压栈的过程，系统在压栈的时候会保留现场
     *
     * @param node 链表
     * @return 反转后的链表
     */
    public Node<E> reverse(Node<E> node) {
        //递归
        if (null == node || null == node.next) {
            return node;
        }
        /*
            此时head=3结点，temp=3结点.next(实际上是4结点)
            执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点
         */
        Node<E> temp = node.next;
        //进入递归
        Node<E> newHead = reverse(node.next);
        /*
           弹栈过程:
            程序继续执行 temp.next = head就相当于4->3
            head.next = null 即把3结点指向4结点的指针断掉
            返回新链表的头结点newHead
         */
        temp.next = node;
        node.next = null;
        return newHead;
    }

    /**
     * 判断链表是否是回文链表
     *
     * @param node /
     * @return /
     */
    public boolean isPalindrome(Node<E> node) {
        //链表是空，或者只有一个元素
        if (node == null || node.next == null) {
            return true;
        }
        //快慢指针找到链表的中点
        //快指针是慢指针的2倍，快指针为空或者快指针的下一个节点为空，证明慢指针找到了链表的中点
        Node<E> fast = node.next.next;
        Node<E> slow = node.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //链表的中点
            slow = slow.next;
        }
        //翻转链表前半部分
        Node<E> pre = null;
        Node<E> temp = null;
        while (node != slow) {
            temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        /*
            //边移动（找中点），边反转
            Node slow = head, fast = head;
            Node pre = head, prepre = null;
            while(fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                pre.next = prepre;
                prepre = pre;
            }
         */
        //如果是奇数个节点，去掉后半部分的第一个节点。
        if (fast != null) {
            slow = slow.next;
        }
        //回文校验,前后链表一次进行对比
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NULL");
        return res.toString();
    }

    @Test
    public void test() {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println("---链表添加元素---");
        linkedList.add(2, 6);
        System.out.println(linkedList);

        System.out.println("链表删除元素");
        Integer integer = linkedList.removeLast();
        System.out.println(integer);
        System.out.println(linkedList);

        System.out.println("---遍历法实现链表反转---");
        Node<Integer> node = linkedList.reverseIteratively(linkedList.dummyHead);
        while (node != null) {
            System.out.print(node.e + "—>");
            node = node.next;
        }
    }


}

