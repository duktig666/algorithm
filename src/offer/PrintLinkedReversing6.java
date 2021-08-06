package offer;

import java.util.Stack;

/**
 * description:《剑指offer》第六题——从尾到头打印单链表
 *
 * @author RenShiWei
 * Date: 2021/7/7 20:50
 **/
public class PrintLinkedReversing6<E> {

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

    PrintLinkedReversing6() {
        head = new Node<>();
    }

    /**
     * 在链表末尾添加元素
     */
    public void add(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e);
    }

    /**
     * 从前往后遇到第一个e，删除节点
     */
    public void del(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(e)) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            throw new IllegalArgumentException("Del fail——Not found e");
        } else {
            temp.next = temp.next.next;
        }
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
        PrintLinkedReversing6<Integer> linked = new PrintLinkedReversing6<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.del(2);
        linked.backPrint(linked.head);
        System.out.println("------");
        linked.backPrintRecursion(linked.head);
    }

}

