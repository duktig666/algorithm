package datastructure.sort;

import java.util.Arrays;

/**
 * description:希尔排序 @see https://blog.csdn.net/qq_42937522/article/details/105128083
 * <p>
 * 平均时间复杂度O(n^2/3),最坏时间复杂度为O(n^2),空间复杂度为O(1),不稳定
 *
 * @author RenShiWei
 * Date: 2021/8/4 15:43
 **/
public class ShellSort {

    /**
     * 希尔排序（更易理解）
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int interval = 1;
        // 根据数组长度，计算希尔增量（目前来说还算是比较优的一种计算方式）
        while (interval < arr.length / 3) {
            interval = 3 * interval + 1;
        }
        // 不断缩小步长，直至为1
        while (interval >= 1) {
            //根据步长分组进行【直接插入排序】，i初始值为h，每次和分组的前一个元素比较
            for (int i = interval; i < arr.length; i++) {
                for (int j = i; j >= interval && arr[j] < arr[j - interval]; j -= interval) {
                    //分组内元素，左边大于右边，交换元素
                    swap(arr, j, j - interval);
                }
            }
            interval = interval / 3;
        }
    }

    /**
     * 希尔排序
     */
    public static int[] shellSortOld(int[] arr) {
        if (arr.length > 0) {
            //不断缩小增量
            for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
                //增量为1的插入排序
                for (int i = interval; i < arr.length; i++) {
                    int target = arr[i];
                    int j = i - interval;
                    while (j > - 1 && target < arr[j]) {
                        arr[j + interval] = arr[j];
                        j -= interval;
                    }
                    arr[j + interval] = target;
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        shellSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        shellSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}

