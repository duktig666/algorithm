package datastructure.stack;

/**
 * description：使用链表来实现栈
 *
 * @author RenShiWei
 * Date: 2019/11/23
 * Time: 17:15
 **/
public class LinkedStack<E> implements Stack<E> {

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E data) {
            this(data, null);
        }
    }

    /** 栈的节点个数 */
    private int size;

    /** 栈顶元素 */
    private Node<E> top;

    public LinkedStack() {
        top = new Node<>();
        size = 0;
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
     * 每次在0号索引位添加元素
     *
     * @param e 添加的元素
     */
    @Override
    public void push(E e) {
        Node<E> oldTop = top;
        /*
            相当于三步操作：
            top = new Node<>();
            top.data = e;
            top.next = oldTop;
         */
        top = new Node<>(e, oldTop);
        size++;
    }

    /**
     * 在栈中删除一个元素（出栈）
     * 每次删除0号索引位的元素
     *
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        E oldData = top.data;
        top = top.next;
        size--;
        return oldData;
    }

    /**
     * @return 返回栈最顶层的元素
     */
    @Override
    public E peek() {
        return top.data;
    }

    /**
     * @return 输出栈中的元素
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:TOP ");
        while (top.data != null) {
            res.append(top.data).append("->");
            top = top.next;
        }
        res.append("NULL END");
        return res.toString();
    }

    /**
     * 测试栈
     */
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Integer del = stack.pop();
        System.out.println("栈删除元素：" + del);
        System.out.println(stack);
    }


}

