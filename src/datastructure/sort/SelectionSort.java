package datastructure.sort;

import java.util.Arrays;

/**
 * description:选择排序 @see https://blog.csdn.net/qq_42937522/article/details/105127914
 * <p>
 * 总结：两次循环。第一次循环，每次将最小元素放置数组靠前位置，每次循环，索引+1（向后移一位，保证从小到大）
 * 第二次循环，当前元素每次与最小元素比较，如果当前元素小于最小元素，将最小元素索引改为当前索引
 * <p>
 * 平均、最好、最坏时间复杂度O(n^2)， 额外空间复杂度O(1)，不稳定（中间有数组元素的交换，相同的元素不一定选择哪一个）
 *
 * @author RenShiWei
 * Date: 2020/2/9 17:42
 **/
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //进行循环，每次找出最小的一个数进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            //最小数索引
            int minIndex = i;
            //每次与后一个元素进行比较，若果前者大，则交换元素位置（保证有小到大排列）
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        selectionSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

}

