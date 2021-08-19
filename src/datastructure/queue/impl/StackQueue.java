package datastructure.queue.impl;

import datastructure.queue.Queue;

import java.util.Stack;

/**
 * description:两个栈实现队列
 *
 * @author RenShiWei
 * Date: 2021/8/19 16:52
 **/
public class StackQueue<E> implements Queue<E> {

    private Stack<E> stack1;
    private Stack<E> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * @return 是否队空
     */
    @Override
    public boolean isEmpty() {
        return stack1.empty() && stack2.empty();
    }

    /**
     * @return 队列元素个数
     */
    @Override
    public int getSize() {
        return stack1.size() + stack2.size();
    }

    /**
     * 入队：只考虑将元素添加至stack1
     *
     * @param e 入队元素
     */
    @Override
    public void add(E e) {
        stack1.push(e);
    }

    /**
     * 出队：
     * 若stack2为空，将stack1元素依次出栈，并压栈进stack2；stack2弹出栈顶元素
     * 若stack2不为空，直接弹出栈顶元素
     *
     * @return 出队元素
     */
    @Override
    public E poll() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is null.Don't delete!");
        }
        if (stack2.empty()) {
            while (! stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getHead() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is null.Don't delete!");
        }
        if (stack2.empty()) {
            while (! stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * 先输出stack2再输出stack1
     * 顺序stack2+逆序stack1即为队列元素顺序
     */
    public String toStringForStack() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack2 TOP:");
        for (E value : stack2) {
            sb.append(value).append(" ");
        }
        sb.append("\nStack1 TOP:");
        for (E value : stack1) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    /**
     * 输出队列的元素
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue TOP:");
        for (E value : stack2) {
            sb.append(value).append(" ");
        }
        Stack<E> stackTemp = new Stack<>();
        for (E value : stack1) {
            stackTemp.push(value);
        }
        for (E value : stackTemp) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.toStringForStack());
        System.out.println("出队：" + queue.poll());
        System.out.println(queue.toStringForStack());

        queue.add(4);

        System.out.println(queue.toStringForStack());
        System.out.println("出队：" + queue.poll());
        System.out.println(queue.toStringForStack());

        System.out.println(queue);
    }

}

