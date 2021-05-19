package leetcode.binarysearch;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * 思路：很容易可以想到暴力循环破解
 * 数组有序，可以使用二分查找法，但是临界条件比较难想
 *
 * @author RenShiWei
 * Date: 2021/5/18 9:17
 **/
public class 有序数组中的单一元素_540 {

    /**
     * description:官方题解——二分搜索
     * 二分法，每次选取中间一对重复的元素，单一元素一定在是奇数的子数组中
     *
     * @author RenShiWei
     * Date: 2021/5/19 9:37
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean halvesAreEven = (r - m) % 2 == 0;
            if (nums[m + 1] == nums[m]) {
                //中间元素和右边元素相等
                if (halvesAreEven) {
                    //右边为奇数
                    l = m + 2;
                } else {
                    //左边为奇数
                    r = m - 1;
                }
            } else if (nums[m - 1] == nums[m]) {
                //中间元素和左边元素相等
                if (halvesAreEven) {
                    //左边为奇数
                    r = m - 2;
                } else {
                    //右边为奇数
                    l = m + 1;
                }
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }

    /**
     * description:官方题解——仅对偶数位二分搜索
     * 二分法，单一元素前，偶数位的后一位与偶数位相同，反之亦然，判断选取左右哪边
     *
     * @author RenShiWei
     * Date: 2021/5/19 9:37
     */
    public int singleNonDuplicate2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            //如果mid是奇数位，左移一位
            if (m % 2 == 1) {
                m--;
            }
            //判断偶数位与后一位是否相同
            if (nums[m] == nums[m + 1]) {
                //相同，单一元素在右边
                l = m + 2;
            } else {
                //不相同，单一元素在左边
                r = m;
            }
        }
        return nums[l];
    }

    @Test
    public void test() {
        int[] arr1 = new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] arr2 = new int[] {3, 3, 7, 7, 10, 11, 11};
        System.out.println("官方题解——二分搜索 测试用例");
        System.out.println(singleNonDuplicate(arr1));
        System.out.println(singleNonDuplicate(arr2));
        System.out.println("官方题解——仅对偶数位二分搜索 测试用例");
        System.out.println(singleNonDuplicate2(arr1));
        System.out.println(singleNonDuplicate2(arr2));
    }

}

