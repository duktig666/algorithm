package leetcode.stack;

import java.util.*;

/**
 * description:
 * <p>
 * Java里面是建议使用Deque替换Stack
 *
 * @author RenShiWei
 * Date: 2021/12/1 20:59
 **/
public class 下一个更大的元素 {

    /**
     * 单调栈模板
     */
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 倒着往栈⾥放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个⼦⾼矮
            while (! stack.empty() && stack.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                stack.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = stack.empty() ? - 1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    /**
     * 496. 下一个更大元素 I
     * https://leetcode-cn.com/problems/next-greater-element-i/
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // 倒着往栈⾥放
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 判定个⼦⾼矮
            while (! stack.empty() && stack.peek() <= nums2[i]) {
                // 矮个起开，反正也被挡着了。。。
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? - 1 : stack.peek());
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++ i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    /**
     * 503. 下一个更大元素 II（环形数组）
     * https://leetcode-cn.com/problems/next-greater-element-ii/
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        // 假装这个数组⻓度翻倍了
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引要求模，其他的和模板⼀样
            while (! stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? - 1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }


}

