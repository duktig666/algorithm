package leetcode.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author RenShiWei
 * Date: 2021/12/2 10:03
 **/
public class 单调队列解决滑动窗口最大值_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗⼝的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗⼝开始向前滑动，移⼊新元素
                window.push(nums[i]);
                // 将当前窗⼝中的最⼤元素记⼊结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 单调队列的实现
     */
    static class MonotonicQueue {

        // 双链表，⽀持头部和尾部增删元素
        private Deque<Integer> q = new LinkedList<>();

        /**
         * 单调队列新增元素：
         * 新增前删除前面比当前元素小的元素，保证队列单调递减
         * 出队时，队首即最大值
         */
        public void push(int n) {
            // 将前⾯⼩于⾃⼰的元素都删除
            while (! q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        /**
         * 队头的元素肯定是最⼤的
         */
        public int max() {
            return q.getFirst();
        }

        /**
         * 在队头删除元素 n
         */
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }

    }

}

