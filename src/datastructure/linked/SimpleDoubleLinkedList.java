package datastructure.linked;

/**
 * description:双向链表的简单实现方式
 *
 * @author RenShiWei
 * Date: 2021/7/2 22:02
 **/
public class SimpleDoubleLinkedList<E> {

    /**
     * 自定义节点
     */
    private static class Node<E> {

        /**
         * 当前值
         */
        private E data;

        /**
         * 左节点
         */
        private Node<E> left;

        /**
         * 右节点
         */
        private Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        E getData() {
            return data;
        }

        void setData(E data) {
            this.data = data;
        }

        Node<E> getLeft() {
            return left;
        }

        void setLeft(Node<E> left) {
            this.left = left;
        }

        Node<E> getRight() {
            return right;
        }

        void setRight(Node<E> right) {
            this.right = right;
        }

    }

    /**
     * 头结点
     */
    private Node<E> head;

    /**
     * 当前节点（尾节点）
     */
    private Node<E> current;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getCurrent() {
        return current;
    }

    /**
     * 添加节点
     * 如果头节点为空，则赋值为当前节点
     * 否则，要双向设置，当前节点向后移动一位
     *
     * @param data 当前节点的值
     */
    public void add(E data) {
        if (head == null) {
            head = new Node<E>(data);
            current = head;
        } else {
            Node<E> tmp = new Node<>(data);
            current.setRight(tmp);
            tmp.setLeft(current);
            current = current.getRight();
        }
    }

    /**
     * 正向打印链表
     *
     * @param node 当前节点
     */
    public void print(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print("First->Last:");
        Node<E> tmp = node;
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getRight();
        }
        System.out.println("");
    }


    /**
     * 反向打印链表
     *
     * @param node 当前节点
     */
    public void printRev(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print("Last->First:");
        Node<E> tmp = node;
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getLeft();
        }
        System.out.println("");
    }

    /**
     * 链表倒置
     */
    public void reversed() {
        if (head == null || head.getRight() == null) {
            return;
        }
        current = head;
        while (true) {
            //交换左右节点
            Node<E> tmp = head.getLeft();
            head.setLeft(head.getRight());
            head.setRight(tmp);

            //如果左节点为空，则终止，否则循环执行
            if (head.getLeft() == null) {
                return;
            } else {
                head = head.getLeft();
            }
        }
    }

    public static void main(String[] args) {
        SimpleDoubleLinkedList<Integer> list = new SimpleDoubleLinkedList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        System.out.println("正向打印: ");
        list.print(list.getHead());

        System.out.println("逆向打印 ");
        list.printRev(list.getCurrent());

        System.out.println("链表倒置后正向打印 ");
        list.reversed();
        list.print(list.getHead());
    }

}

