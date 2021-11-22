package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * description:https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author RenShiWei
 * Date: 2021/11/22 10:53
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class 和为K的子数组_560 {

    /**
     * 借助Map的前缀和
     * 时间复杂度为 O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        // res为符合条件的子数组个数（最终结果）；sumI为数组当前下标的前缀和
        int res = 0, sumI = 0;
        for (int i = 0; i < n; i++) {
            sumI += nums[i];
            // 前缀和为sumJ，说明符合条件
            int sumJ = sumI - k;
            // 如果前⾯有这个前缀和，则直接更新答案
            if (preSum.containsKey(sumJ)) {
                res += preSum.get(sumJ);
            }
            // 把前缀和 nums[0..i] 加⼊并记录出现次数
            preSum.put(sumI, preSum.getOrDefault(sumI, 0) + 1);
        }
        return res;
    }

    /**
     * 前缀和
     * 时间复杂度为 O(n^2)
     */
    public int subarraySumTmp(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        // 穷举所有⼦数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // ⼦数组 nums[j..i-1] 的元素和
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

}

