package datastructure.queue.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:数组来实现简单的阻塞队列
 * <p>
 * 使用 ReentrantLock + Condition
 *
 * @author RenShiWei
 * Date: 2021/8/6 17:06
 **/
public class ArrayBlockQueue<T> {

    /** 存放元素的数组 */
    private T[] data;

    /** 实际的元素个数 */
    private int count;

    /** 队首指针 */
    private int head;

    /** 队尾指针 */
    private int tail;

    private Lock lock = new ReentrantLock();
    private Condition notFullCondition = lock.newCondition();
    private Condition notEmptyCondition = lock.newCondition();

    @SuppressWarnings("unchecked")
    public ArrayBlockQueue(int len) {
        data = (T[]) new Object[len];
    }

    /**
     * 阻塞队列入队
     *
     * @param t 入队元素
     */
    public void put(T t) {
        lock.lock();
        try {
            while (count >= data.length) {
                try {
                    System.out.println(Thread.currentThread().getName() + "队列已满，put操作阻塞线程");
                    notFullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.data[tail] = t;
            this.tail = (tail + 1) % this.data.length;
            count++;
            notEmptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞队列出队
     *
     * @return 出队元素
     */
    public T take() {
        lock.lock();//获取锁不能写在try块中，如果发生异常，锁会被释放
        try {
            while (count == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "队列已空，take操作阻塞线程");
                    notEmptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = data[head];
            this.head = (head + 1) % data.length;
            count--;
            notFullCondition.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 测试
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayBlockQueue<Integer> blockingQueue = new ArrayBlockQueue<>(10);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                blockingQueue.put(i);
                System.out.println("put-num:" + i);
            }
        });
        try {
            thread.start();
            //等待thread执行完毕后再进行操作
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Integer num = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "-take-num:" + num);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                Integer num = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "-take-num:" + num);
            }
        }).start();

    }

}

