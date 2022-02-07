package leetcode.codetop;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author RenShiWei
 * Date: 2022/2/7 14:57
 **/
public class codetop32_用栈实现队列_232 {

    /**
     * 用栈实现队列：
     * 1. 入队：stack1永远入栈
     * 2. 出队：从stack2弹栈，若stack2位empty，将stack1元素依次移动到stack2中
     */
    class MyQueue {

        Stack<Integer> stack1, stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack1.empty() && stack2.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            if (stack2.empty()) {
                while (! stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack1.empty() && stack2.empty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            if (stack2.empty()) {
                while (! stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }

    }

    /**
     * https://leetcode-cn.com/problems/implement-stack-using-queues/
     * 用队列实现栈：
     * 1. 入栈：元素添加在不为empty的queue中，两个都是empty可随便添加
     * 2. 出栈：将有元素队列的元素依次移动到另一个队列，留下最后一个元素即是出栈的元素
     */
    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }


}

