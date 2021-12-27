package leetcode.codetop;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * description:https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * @author RenShiWei
 * Date: 2021/12/9 19:19
 **/
public class 最大子数组和_53 {

    /**
     * 贪心思路：若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
     * 1. 遍历元素，记录【当前和】【最大和】
     * 2. 当前所指的元素之前的和小于0，丢弃，当前和为当前元素
     * 3. 当前和 和 最大和 取最大值
     */
    public int maxSubArray(int[] nums) {
        // 初始值设为第一个元素
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 若当前所指元素之前的和小于0，丢弃之前的数列
            curSum = Math.max(nums[i], curSum + nums[i]);
            // 当前和与最大和取最大
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划思路：若前一个元素大于0，则将其加到当前元素上
     * 1. 遍历元素，若前一个元素大于0，则将其加到当前元素上
     * 2. 遍历元素，取最大值即为最后的结果
     */
    public int maxSubArrayDp(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        OptionalInt optionalInt = Arrays.stream(nums).max();
        int res = 0;
        if (optionalInt.isPresent()) {
            res = optionalInt.getAsInt();
        }
        return res;
    }

}

