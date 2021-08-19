package datastructure.stack.impl;

import datastructure.stack.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:两个队列实现栈
 *
 * @author RenShiWei
 * Date: 2021/8/19 20:46
 **/
public class QueueStack<E> implements Stack<E> {

    private Queue<E> queue1;
    private Queue<E> queue2;

    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * @return 获取栈的大小
     */
    @Override
    public int getSize() {
        return queue1.size() + queue2.size();
    }

    /**
     * @return 判断栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     * 入队：元素添加至不是空的队列当中，两个都是null无所谓
     *
     * @param e 入队元素
     */
    @Override
    public void push(E e) {
        if (queue2.isEmpty()) {
            queue1.add(e);
        } else {
            queue2.add(e);
        }
    }

    /**
     * 出队：将不为null的队列元素出队，并入队到另一个队列当中，最后剩下的那个即为该出队的元素
     *
     * @return 出队元素
     */
    @Override
    public E pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalArgumentException("Remove failed. Stack is empty!");
        } else if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /**
     * @return 返回栈最顶层的元素
     */
    @Override
    public E peek() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalArgumentException("Remove failed. Stack is empty!");
        }
        Queue<E> queueTemp = new LinkedList<>();
        if (! queue1.isEmpty()) {
            copy(queueTemp, queue1);
        } else {
            copy(queueTemp, queue2);
        }
        while (queueTemp.size() > 1) {
            queueTemp.poll();
        }
        return queueTemp.poll();
    }

    /**
     * 队列拷贝
     *
     * @param target 目标队列
     * @param src    源队列
     */
    private void copy(Queue<E> target, Queue<E> src) {
        while (! src.isEmpty()) {
            target.add(src.poll());
        }
    }

    /**
     * 输出两个栈的情况
     */
    public String toStringForQueue() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue1 TOP:");
        for (E value : queue1) {
            sb.append(value).append(" ");
        }
        sb.append("\nQueue2 TOP:");
        for (E value : queue2) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    /**
     * 输出栈的元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (E value : queue1) {
            sb.append(value).append(" ");
        }
        for (E value : queue2) {
            sb.append(value).append(" ");
        }
        sb.append("] Stack TOP");
        return sb.toString();
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        QueueStack<Integer> stack = new QueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toStringForQueue());
        System.out.println("出栈：" + stack.pop());
        System.out.println(stack.toStringForQueue());

        System.out.println("添加元素");
        stack.push(4);

        System.out.println(stack.toStringForQueue());
        System.out.println("出栈：" + stack.pop());
        System.out.println(stack.toStringForQueue());

        System.out.println(stack);

        System.out.println("栈顶：" + stack.peek());

    }


}

