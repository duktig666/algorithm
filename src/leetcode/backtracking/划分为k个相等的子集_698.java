package leetcode.backtracking;

import java.util.Arrays;

/**
 * description: https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 * @author RenShiWei
 * Date: 2022/1/19 20:15
 **/
public class 划分为k个相等的子集_698 {

    // 方法一：以数字的视角

    /**
     * 主函数
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;

        // 降序排列，优化时间复杂度
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    /**
     * 递归穷举 nums 中的每个数字
     */
    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {

        if (index == nums.length) {
            // 检查所有桶的数字之和是否都是 target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            // nums 成功平分成 k 个子集
            return true;
        }

        // 穷举 nums[index] 可能装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，桶装装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];
            // 递归穷举下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }

        // nums[index] 装入哪个桶都不行
        return false;
    }

    // 方法二：以桶的视角

    /**
     * 主函数
     */
    boolean canPartitionKSubsets2(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack2(k, 0, nums, 0, used, target);
    }

    /**
     * 回溯
     *
     * @param k      第几号桶
     * @param bucket 桶里的数字之和
     * @param nums   数组
     * @param start  开始位置
     * @param used   数字是否装进桶中（boolean数组）
     * @param target 每个桶要达到的目标和
     * @return 是否可以划分子集
     */
    private boolean backtrack2(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            // 因为 target == sum / k
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack2(k - 1, 0, nums, 0, used, target);
        }

        // 从 start 开始向后探查有效的 nums[i] 装入当前桶
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (used[i]) {
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                // 当前桶装不下 nums[i]
                continue;
            }
            // 做选择，将 nums[i] 装入当前桶中
            used[i] = true;
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack2(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used[i] = false;
            bucket -= nums[i];
        }
        // 穷举了所有数字，都无法装满当前桶
        return false;
    }

}

