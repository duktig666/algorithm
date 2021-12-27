package interview;

import org.junit.Test;

/**
 * description: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和≥s的长度最小的连续子数组,并返回其长度。如果不存在符合条件的子数组，返回0.
 *
 * @author RenShiWei
 * Date: 2021/12/24 15:22
 **/
public class 长度为S的连续数组_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            int numR = nums[right];
            sum += numR;
            right++;
            while (sum >= target) {
                int numL = nums[left];
                sum -= numL;
                left++;
                res = Math.min(res, right - left + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    @Test
    public void test() {
        int[] arr = new int[] {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, arr));
    }

}

