package datastructure.stack;

import datastructure.linked.SingleLinkedList;

/**
 * description:自定实现的单链表来实现栈
 *
 * @author RenShiWei
 * Date: 2019/11/23
 **/
public class SingleLinkedListStack<E> implements Stack<E> {

    private SingleLinkedList<E> list;

    public SingleLinkedListStack() {
        list = new SingleLinkedList<>();
    }

    /**
     * @return 返回栈的元素个数
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * @return 判断栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * @param e 向栈中添加一个元素(入栈)
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * @return 在栈中删除一个元素（出栈）
     */
    @Override
    public E pop() {
        return (E) list.removeFirst();
    }

    /**
     * @return 返回栈最顶层的元素
     */
    @Override
    public E peek() {
        return (E) list.getFirst();
    }

    /**
     * @return 输出栈中的元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:TOP ");
        res.append(list);
        res.append(" END");
        return res.toString();
    }

    /**
     * 测试栈
     */
    public static void main(String[] args) {
        SingleLinkedListStack<Integer> stack = new SingleLinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Integer del = stack.pop();
        System.out.println("栈删除元素：" + del);
        System.out.println(stack);
    }

}

