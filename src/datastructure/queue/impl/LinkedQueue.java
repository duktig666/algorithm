package datastructure.queue.impl;

import datastructure.queue.Queue;

/**
 * description:链表实现队列
 *
 * @author RenShiWei
 * Date: 2021/8/14 17:21
 **/
public class LinkedQueue<E> implements Queue<E> {

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E data) {
            this(data, null);
        }

        @Override
        public String toString() {
            return data == null ? "" : data.toString();
        }
    }

    /** 节点个数 */
    private int size;

    /**
     * 头结点、尾节点
     */
    private Node<E> head, tail;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return 是否队空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return 队列元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 队尾入队
     *
     * @param e 入队元素
     */
    @Override
    public void add(E e) {
        if (tail == null) {
            //尾部为空，即队空
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 队首出队
     *
     * @return 出队元素
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        //待删除节点
        Node<E> retNode = head;
        //队首结点移动
        head = head.next;
        retNode.next = null;
        size--;
        return retNode.data;
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getHead() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node<E> cur = head;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        Integer poll = queue.poll();
        System.out.println("队列出队：" + poll);
        System.out.println(queue);
    }

}

