package datastructure.queue.impl;

import datastructure.queue.Queue;

import java.util.Scanner;

/**
 * description:循环队列
 *
 * @author RenShiWei
 * Date: 2021/5/30 16:38
 **/
public class LoopQueue<E> implements Queue<E> {

    /** 存储元素 数组的长度（有效长度需要-1） */
    private int maxSize;
    /** 队列头 */
    private int front;
    /** 队列尾 */
    private int rear;
    /** 该数据用于存放数据，模拟队列 */
    private E[] data;

    /**
     * 初始化环形队列
     *
     * @param arrMaxSize 初始队列容量
     */
    @SuppressWarnings("unchecked")
    public LoopQueue(int arrMaxSize) {
        //循环队列需要有意识浪费一个空间
        maxSize = arrMaxSize + 1;
        data = (E[]) new Object[maxSize];
    }

    /**
     * @return 是否队空
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * @return 是否队满
     */
    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * @return 队列的可承载元素个数
     */
    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * @return 队列元素个数
     */
    @Override
    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 队尾入队
     *
     * @param e 入队元素
     */
    @Override
    public void add(E e) {
        if (isFull()) {
            throw new IllegalArgumentException("队列已满，不能入队！");
        }
        data[rear] = e;
        //rear指针后移一位
        rear = (rear + 1) % maxSize;
    }

    /**
     * 队首出队
     *
     * @return 出队元素
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空，不能出队！");
        }
        E temp = data[front];
        //出队位置置null
        data[front] = null;
        //front指针后移一位
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 获取队首元素
     * 如果队空，返回null
     *
     * @return 队首元素
     */
    @Override
    public E getHead() {
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != rear; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != rear) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    /**
     * 队列测试
     */
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        Scanner sc = new Scanner(System.in);
        char c;
        boolean loop = true;
        while (loop) {
            System.out.println("s(toString):输出队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("p(poll):从队列取出数据");
            System.out.println("h(getHead):查看队列头的数据");
            System.out.println("n(isEmpty):是否队空");
            System.out.println("f(isFull):是否队满");
            c = sc.next().charAt(0);
            switch (c) {
                case 's':
                    System.out.println("当前队列：" + queue.toString());
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    queue.add(sc.nextInt());
                    break;
                case 'p':
                    System.out.printf("出队元素：%d\n", queue.poll());
                    break;
                case 'h':
                    System.out.printf("队首元素：%d\n", queue.getHead());
                    break;
                case 'n':
                    System.out.println("队空：" + queue.isEmpty());
                    break;
                case 'f':
                    System.out.println("队满：" + queue.isFull());
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }


}

