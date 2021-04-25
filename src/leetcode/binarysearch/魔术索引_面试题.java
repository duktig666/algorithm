package leetcode.binarysearch;

import org.junit.Test;

/**
 * description:面试题 08.03. 魔术索引
 * https://leetcode-cn.com/problems/magic-index-lcci/
 *
 * @author RenShiWei
 * Date: 2021/4/22 16:19
 **/
public class 魔术索引_面试题 {

    /**
     * 暴力破解法
     * 循环遍历，遇到   “最小的索引值 = 数值”   直接返回
     * 时间复杂度： O(n)
     *
     * @param nums 有序整数数组
     * @return 魔术索引
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return - 1;
    }

    /**
     * 对上述暴力解法进行优化
     * 因为是有序数组，若 nums[i]!=i , 下标[i,nums[i])区间内将不会产生结果
     * 在此区间内遍历属于无用功，则i可以直接跳到nums[i]位置继续向后遍历
     *
     * @param nums 有序整数数组
     * @return 魔术索引
     */
    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            } else {
                i = Math.max(nums[i], i + 1);
            }
        }
        return - 1;
    }

    @Test
    public void test1() {
        System.out.println(findMagicIndex(new int[] {0, 2, 3, 4, 5}));
        System.out.println(findMagicIndex(new int[] {1, 1, 1}));
    }

    /**
     * 二分查找法
     *
     * @param nums 有序整数数组
     * @return 魔术索引
     */
    public int findMagicIndex2(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    /**
     * 官方题解
     */
    private int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return - 1;
        }
        int mid = (right - left) / 2 + left;
        //现在左半部分查找
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != - 1) {
            //不等于-1说明找到
            return leftAnswer;
        } else if (nums[mid] == mid) {
            //相等说明索引值即为结果
            return mid;
        }
        //都没找到去右半部分查找
        return getAnswer(nums, mid + 1, right);
    }


}

