package offer;

import java.util.Stack;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/7/7 20:50
 **/
public class PrintLinkedReversing_6<E> {

    static class Node<E> {

        E data;

        Node<E> next;

        private Node() {

        }

        private Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    private Node<E> head;

    PrintLinkedReversing_6() {
        head = new Node<>();
    }

    public void add(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e);
    }

    /**
     * 利用栈的特性打印链表
     */
    public void backPrint(Node<E> head) {
        Stack<E> stack = new Stack<>();
        Node<E> temp = head;
        while (temp.next != null) {
            stack.push(temp.next.data);
            temp = temp.next;
        }
        for (int i = stack.size(); i > 0; i--) {
            E e = stack.pop();
            System.out.println(e);
        }
    }

    /**
     * 递归反向打印链表
     */
    public void backPrintRecursion(Node<E> head) {
        if (head.next == null) {
            return;
        }
        backPrintRecursion(head.next);
        System.out.println(head.next);
    }

    public static void main(String[] args) {
        PrintLinkedReversing_6<Integer> linked = new PrintLinkedReversing_6<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.backPrint(linked.head);
        System.out.println("------");
        linked.backPrintRecursion(linked.head);
    }

}

