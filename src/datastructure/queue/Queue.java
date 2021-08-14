package datastructure.queue;

/**
 * description:自定义队列接口
 *
 * @author RenShiWei
 * Date: 2021/5/29 20:45
 **/
public interface Queue<E> {

    /**
     * @return 是否队空
     */
    boolean isEmpty();


    /**
     * @return 队列元素个数
     */
    int getSize();

    /**
     * 队尾入队
     *
     * @param e 入队元素
     */
    void add(E e);

    /**
     * 队首出队
     *
     * @return 出队元素
     */
    E poll();

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    E getHead();

}
