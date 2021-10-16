package datastructure.queue.blockqueue;

/**
 * description:数组来实现简单的阻塞队列
 * <p>
 * 使用 synchronized + wait() + notifyAll()
 *
 * @author RenShiWei
 * Date: 2021/8/6 16:34
 **/
public class SimpleArrayBlockQueue<T> {

    /** 实际的元素个数 */
    private int count;

    /** 队首指针 */
    private int head;

    /** 队尾指针 */
    private int tail;

    /** 存放元素的数组 */
    private T[] data;

    @SuppressWarnings("unchecked")
    public SimpleArrayBlockQueue(int arrLen) {
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        data = (T[]) new Object[arrLen];
    }

    /**
     * 阻塞队列入队
     *
     * @param data 入队元素
     */
    public synchronized void put(T data) {
        while (count >= this.data.length) {
            try {
                System.out.println(Thread.currentThread().getName() + "队列已满，put操作阻塞线程");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data[tail] = data;
        this.tail = (tail + 1) % this.data.length;
        count++;
        notifyAll();
    }

    /**
     * 阻塞队列出队
     *
     * @return 出队元素
     */
    public synchronized T take() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "队列已空，take操作阻塞线程");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = data[head];
        this.head = (head + 1) % data.length;
        count--;
        notifyAll();
        return t;
    }

    /**
     * @return 阻塞队列的长度
     */
    public synchronized int size() {
        return data.length;
    }

    /**
     * 测试
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        SimpleArrayBlockQueue<Integer> blockingQueue = new SimpleArrayBlockQueue<Integer>(10);
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

