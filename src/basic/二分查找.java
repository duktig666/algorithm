package basic;

import org.junit.Test;

/**
 * description:二分查找代码实现
 *
 * @author RenShiWei
 * Date: 2021/4/22 16:51
 **/
public class 二分查找 {

    /**
     * 二分查找法 循环实现
     *
     * @param arr 待查找数组
     * @param num 待查询数
     * @return num在arr的索引位置，不存在返回-1
     */
    public int binarySearchByLoop(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        //临界值快速判断（num小于数组左边或者大于右边，必定找不到——二分查找前提，数组有序）
        if (arr[start] > num || arr[end] < num) {
            return - 1;
        }
        while (start <= end) {
            //防止出现越界
            int mid = start + (end - start) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return - 1;
    }

    /**
     * 二分查找法 递归实现
     *
     * @param arr   待查找数组
     * @param num   待查询数
     * @param start 起始位置
     * @param end   结束位置
     * @return num在arr的索引位置，不存在返回-1
     */
    public int binarySearchByRecursion(int[] arr, int num, int start, int end) {
        //临界值快速判断（num小于数组左边或者大于右边，必定找不到——二分查找前提，数组有序）   start > end 为递归终止条件
        if (arr[start] > num || arr[end] < num || start > end) {
            return - 1;
        }
        int mid = start + (end - start) / 2;
        if (num == arr[mid]) {
            return mid;
        } else if (num < arr[mid]) {
            return binarySearchByRecursion(arr, num, start, mid - 1);
        } else {
            return binarySearchByRecursion(arr, num, mid + 1, end);
        }
    }


    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 10, 25, 36, 58};
        System.out.println(binarySearchByLoop(arr, 10));
        System.out.println(binarySearchByRecursion(arr, 10, 0, arr.length - 1));
    }

}

