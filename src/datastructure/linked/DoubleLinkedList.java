package datastructure.linked;

/**
 * description:双向链表
 *
 * @author RenShiWei
 * Date: 2021/7/2 21:02
 **/
public class DoubleLinkedList<E> {

    /**
     * 表示双向链表的节点
     */
    private static class Node<E> {

        E e;

        /** 前驱节点 */
        Node<E> pre;

        /** 后继节点 */
        Node<E> next;

        //索引（算法题中的量，并不在数据中使用）
        int val;

        Node(int x) { val = x; }

        Node(E e, Node<E> pre, Node<E> next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }

        Node(E e) {
            this(e, null, null);
        }

        Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    /**
     * 虚拟头结点<br>
     * 单链表增加一个头节点的优点如下:<br>
     * 1.第一个节点的操作和表中其他节点的操作相一致，无需进行特殊处理；<br>
     * 2.无论链表是否为空，都有一个头节点，因此空表和非空表的处理也就统一了。
     */
    private Node<E> dummyHead;

    /** 元素个数 */
    private int size;

    public DoubleLinkedList() {
        dummyHead = new Node<E>();
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
     * 在双向链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用：）
     *
     * @param index 索引
     * @param e     要添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node<E> prev = dummyHead;
        //寻找index的前一个元素的指针
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*
            五步合成三步（详情见注释）
                Node node = new Node(e);
                node.next = prev.next;
                prev.next.pre = node;
                node.pre = prev;
                prev.next = node;
         */

        //相当于下边注释的代码操作，新增元素需要做四次指针操作
        Node<E> newNode = new Node<>(e, prev, prev.next);
        prev.next = newNode;
        prev.next.pre = newNode;

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
     * 获得链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用：）
     *
     * @param index /
     * @return /
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        //直接代表索引为0的node节点
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
     * 在链表中不是一个常用的操作，练习用：）
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
     * 在链表中不是一个常用的操作，练习用：）
     *
     * @param index /
     * @return /
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        //找到index的上一个元素的指针域
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*
            操作语句：
            p->next->next->prior = p
            p->next = p->next->next
         */
        Node<E> retNode = prev.next;
        prev.next.next.pre = prev;
        prev.next = prev.next.next;
        retNode.next = null;
        retNode.pre = null;

        size--;
        return retNode.e;
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
        //找到元素e的上一个节点，执行上边删除元素节点的重复方法
        Node<E> prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node<E> retNode = prev.next;
            prev.next.next.pre = prev;
            prev.next = prev.next.next;
            retNode.next = null;
            retNode.pre = null;

            size--;
        }
    }

    /**
     * 寻找链表的中点<br>
     * 快慢指针找到链表的中点
     * 快指针是慢指针的2倍，快指针为空或者快指针的下一个节点为空，证明慢指针找到了链表的中点
     *
     * @param head /
     * @return /
     */
    public Node<E> findMidpoint(Node<E> head) {
        Node<E> fast = head.next.next;
        Node<E> slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //链表的中点
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 实现链表的反转（遍历法）
     *
     * @param head 链表
     * @return 反转后的链表
     */
    public Node<E> reverseIteratively(Node<E> head) {
        if (dummyHead == null || dummyHead.next == null) {
            return null;
        }
        // 如果左节点为空，则结束循环
        while (head.pre != null) {
            // 交换左右节点
            Node<E> temp = head.pre;
            head.pre = head.next;
            head.next = temp;
            // 重新指向左边的元素
            head = head.pre;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur.pre).append("<-").append(cur).append("->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addLast("one");
        doubleLinkedList.addLast("two");
        doubleLinkedList.addLast("three");
        doubleLinkedList.addLast("four");

        System.out.println(doubleLinkedList.toString());
        System.out.println("链表删除元素");
        String s = doubleLinkedList.removeFirst();
        System.out.println(s);
        System.out.println(doubleLinkedList.toString());

        System.out.println("---遍历法实现链表反转---");
        doubleLinkedList.reverseIteratively(doubleLinkedList.dummyHead);
        System.out.println(doubleLinkedList.toString());
    }


}

