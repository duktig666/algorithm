package leetcode.binarysearch;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * @author RenShiWei
 * Date: 2021/4/29 21:17
 **/
public class 山脉数组的峰顶索引_852 {

    /**
     * 暴力解法：最简单的解法莫过于一次遍历，比较相邻元素，当前元素左小右小的索引即为结果。时间复杂度为O(n ^ 2)
     * 思路：首先峰顶元素左边正序，右边倒序。有序查找即可使用二分查找法，将时间复杂度降低为O(logn)
     * 解法：二分查找法，mid成立条件——左小右小
     */
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //防止出现越界情况
            if (mid - 1 >= 0 && mid + 1 <= arr.length - 1) {
                //二分法条件
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    //左小右小
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    //左大(因为需要左右比较，所以在赋值时，mid不能+1或者-1)
                    end = mid;
                } else if (arr[mid + 1] > arr[mid]) {
                    //右大(因为需要左右比较，所以在赋值时，mid不能+1或者-1)
                    start = mid;
                }
            } else {
                break;
            }
        }
        return 0;
    }

    /**
     * 根据官方题解优化二分法
     * 官方题解优化后代码行数虽然少了，但是空间实际占用确实多了
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                //找到条件后会在执行一次，所以start的最终结果即为mid
                start = mid + 1;
            } else {
                // 右边的还需要再次比较，所以mid不能-1
                end = mid;
            }
        }
        return start;
    }

    @Test
    public void test() {
        System.out.println("---方法一的测试用例---");
        System.out.println(peakIndexInMountainArray(new int[] {0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[] {0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[] {0, 10, 5, 2}));
        System.out.println(peakIndexInMountainArray(new int[] {3, 4, 5, 1}));
        System.out.println(peakIndexInMountainArray(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(peakIndexInMountainArray(new int[] {3, 5, 3, 2, 0}));
        System.out.println("---方法一优化后的测试用例---");
        System.out.println(peakIndexInMountainArray2(new int[] {0, 1, 0}));
        System.out.println(peakIndexInMountainArray2(new int[] {0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray2(new int[] {0, 10, 5, 2}));
        System.out.println(peakIndexInMountainArray2(new int[] {3, 4, 5, 1}));
        System.out.println(peakIndexInMountainArray2(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(peakIndexInMountainArray2(new int[] {3, 5, 3, 2, 0}));
    }
}

