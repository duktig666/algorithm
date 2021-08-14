package datastructure.queue.impl;

import datastructure.queue.Queue;

/**
 * description:链表实现队列
 *
 * @author RenShiWei
 * Date: 2021/8/14 17:21
 **/
public class LinkedQueue<E> implements Queue<E> {


    /**
     * @return 是否队空
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return 是否队满
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * @return 队列的可承载元素个数
     */
    @Override
    public int getCapacity() {
        return 0;
    }

    /**
     * @return 队列元素个数
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * 队尾入队
     *
     * @param o 入队元素
     */
    @Override
    public void add(Object o) {

    }

    /**
     * 队首出队
     *
     * @return 出队元素
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getHead() {
        return null;
    }
}

