package datastructure.stack;

import datastructure.array.SequenceList;

/**
 * description:使用自定义的动态数组（SequenceList）实现栈（栈满动态扩容）
 *
 * @author RenShiWei
 * Date: 2019/11/23
 **/
public class SequenceListStack<E> implements Stack<E> {

    /**
     * 使用自定义的数组来实现栈的操作（动态对栈进行扩容）
     * 直接调用其api来完成，实质也可以将对数组的操作方法复制过来，也可实现
     */
    private SequenceList<E> array;

    public SequenceListStack(int capacity) {
        array = new SequenceList<>(capacity);
    }

    public SequenceListStack() {
        array = new SequenceList<>();
    }

    /**
     * @return 获取栈的大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * @return 判断栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * @return 栈的空间大小
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 向栈中添加一个元素(入栈)
     *
     * @param e 添加的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 在栈中删除一个元素（出栈）
     *
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * @return 返回栈最顶层的元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * @return 输出栈中的元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        SequenceListStack<Integer> stack = new SequenceListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Integer del = stack.pop();
        System.out.println("栈删除元素：" + del);
        System.out.println(stack);
    }

}

