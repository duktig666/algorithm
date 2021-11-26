package interview;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/11/25 21:10
 **/
public class TreeTest {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {}

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderLoop(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (! stack.empty()) {
            Node cur = stack.pop();
            System.out.println(cur);
            while (cur.right != null) {
                stack.push(cur.right);
            }
            while (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (! queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.data);
            while (cur.left != null) {
                queue.add(cur.left);
            }
            while (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


}

