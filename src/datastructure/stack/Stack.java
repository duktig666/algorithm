package datastructure.stack;

/**
 * description:自定义栈接口
 *
 * @author RenShiWei
 * Date: 2019/11/23
 **/
public interface Stack<E> {

    /**
     * @return 获取栈的大小
     */
    int getSize();

    /**
     * @return 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 向栈中添加一个元素(入栈)
     *
     * @param e 添加的元素
     */
    void push(E e);

    /**
     * 在栈中删除一个元素（出栈）
     *
     * @return 出栈的元素
     */
    E pop();

    /**
     * @return 返回栈最顶层的元素
     */
    E peek();
}
