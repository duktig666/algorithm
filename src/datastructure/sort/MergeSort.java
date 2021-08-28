package datastructure.sort;

import java.util.Arrays;

/**
 * description:归并排序 @see https://blog.csdn.net/qq_42937522/article/details/105128538
 * <p>
 * 时间复杂度O(N*logN)， 额外空间复杂度O(N),稳定
 * <p>
 * 总结：递归,分成两个部分
 * ①左边递归排序
 * 依次压入系统栈，然后挨个return执行函数
 * ②右边递归排序
 * ③所有整合
 *
 * @author RenShiWei
 * Date: 2021/8/28 8:46
 **/
public class MergeSort {

    /**
     * 归并排序入口
     *
     * @param arr /
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归进行，左右两侧排序，然后合并
     *
     * @param arr /
     * @param l   左侧起始索引
     * @param r   右侧起始索引
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        //L 和 R的中点位置，(L+R)/2
        int mid = l + ((r - l) >> 1);
        //左侧排序
        mergeSort(arr, l, mid);
        //右侧排序
        mergeSort(arr, mid + 1, r);
        //整合
        merge(arr, l, mid, r);
    }

    /**
     * 功能描述：数组左右两部分排好序，进行整合
     */
    private static void merge(int[] arr, int l, int m, int r) {
        //辅助数组，保持范围内数组个数一致  r - l + 1
        int[] help = new int[r - l + 1];
        int i = 0;
        //指针分别指向左右两侧的第一个数
        int p1 = l;
        int p2 = m + 1;
        //谁小填谁，跳出这个循环，有且只有一侧必定越界
        while (p1 <= m && p2 <= r) {
            //填完的数，到下一个位置+1
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个循环走一个，将不越界的填进辅助数组
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //辅助数组拷贝给原数组
        for (i = 0; i < help.length; i++) {
            //保证传递给原数组是从l开始的
            arr[l + i] = help[i];
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}

