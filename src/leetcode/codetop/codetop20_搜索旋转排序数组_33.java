package leetcode.codetop;

/**
 * description: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author RenShiWei
 * Date: 2022/1/3 9:36
 **/
public class codetop20_搜索旋转排序数组_33 {

    /**
     * 二分查找法
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return - 1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : - 1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // mid == target   return
            if (nums[mid] == target) {
                return mid;
            }
            // 左半边有序，看左半边
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 左半边无序，看右半边
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return - 1;
    }

    /**
     * 暴力破解
     */
    public int searchTemp(int[] nums, int target) {
        // 只有一个元素的情况
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        int resIndex = - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // nums=1,3   target=1
            if (nums[i] == target) {
                resIndex = i;
            }
            // 正常情况
            if (nums[i] > nums[i + 1] && nums[i + 1] == target) {
                resIndex = i + 1;
            }
            // nums=1,3   target=3
            if (nums[i + 1] == target) {
                resIndex = i + 1;
            }
        }
        return resIndex;
    }

}

