package datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序 @see https://blog.csdn.net/qq_42937522/article/details/105128083
 * 最坏、平均时间复杂度O(n^2)，最好时间复杂度为O(n)， 额外空间复杂度O(1),稳定（扫描相同元素不会再往前扫描）
 *
 * @author RenShiWei
 * <p>
 * 总结：两次循环。第一次循环，从第二个元素开始循环判断
 * 第二次循环，如果左边元素大于右边元素，调换元素位置；如果不是，证明左边都是从小到大排列
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //循环从第二个元素开始判断
        for (int i = 1; i < arr.length; i++) {
            //如果左边元素大于右边元素，调换元素位置；如果不是，证明左边都是从小到大排列
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}
