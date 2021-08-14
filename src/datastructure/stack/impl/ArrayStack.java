package datastructure.stack;

import java.util.Arrays;

/**
 * description:数组实现栈
 *
 * @author RenShiWei
 * Date: 2021/8/14 16:57
 **/
public class ArrayStack<E> implements Stack<E> {

    /** 存储对象的一维数组 */
    private E[] array;

    /** 栈的元素个数 */
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        array = (E[]) new Object[10];
    }

    /**
     * @return 获取栈的大小
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return 判断栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向栈中添加一个元素(入栈)
     *
     * @param e 添加的元素
     */
    @Override
    public void push(E e) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = e;
    }

    /**
     * 数组扩容
     *
     * @param max 预扩容的数组大小
     */
    private void resize(int max) {
        array = Arrays.copyOf(array, max);
    }

    /**
     * 在栈中删除一个元素（出栈）
     *
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        E e = array[-- size];
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return e;
    }

    /**
     * @return 返回栈最顶层的元素
     */
    @Override
    public E peek() {
        return array[size - 1];
    }

    /**
     * @return 输出栈中的元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(array[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Integer del = stack.pop();
        System.out.println("栈删除元素：" + del);
        System.out.println(stack);
    }

}

