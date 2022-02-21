package datastructure.sort;

import java.util.Arrays;

/**
 * description:快速排序简单实现（随机主元 + 双指针双向扫描）
 * <p>
 * 完整版的快速排序分析，参看 src/datastructure/sort/QuickSortFull.java
 * <p>
 * 时间复杂度：最好、平均 O(nlogn) 最坏 O（n^2） 空间复杂度：O（1） 不稳定（远距离的调换元素）
 *
 * @author RenShiWei
 * Date: 2021/8/28 9:53
 **/
public class QuickSort {

    /**
     * 交换数组中两个元素的位置
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 随机主元法：
     * 取数组随机一个元素作为主元，防止到数组尾端 （如果需要以数组左侧第一个元素为主元，那么应将随机主元 与 l进行交换位置）
     */
    private static void randomPrimary(int[] arr, int l, int r) {
        swap(arr, l + (int) (Math.random() * (r - l + 1)), l);
    }

    /**
     * 使用快排对数组排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 使用快排对指定索引区间的数组进行排序
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //随机主元
            randomPrimary(arr, l, r);
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    /**
     * 双向扫描法（左侧为主元）：
     * 双指针，双向扫描，并返回主元元素的下标
     *
     * @param arr /
     * @param l   /
     * @param r   /
     * @return 只有两个元素的数组，是等于主元的区间
     */
    private static int partition(int[] arr, int l, int r) {
        //以数组最左侧的值为目标值
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            //left不停的往右走，知道遇到大于主元的元素
            while (less <= more && arr[less] <= pivot) {
                //循环退出时，left一定指向第一个大于主元的元素
                less++;
            }
            while (less <= more && pivot < arr[more]) {
                //循环退出时，right一定指向第一个小于主元的元素
                more--;
            }
            if (less <= more) {
                swap(arr, less, more);
            }
        }
        //while退出时，两者交错，more一定指向第一个小于主元的元素
        swap(arr, l, more);
        return more;
    }

    public static void main(String[] args) {
        System.out.println("---测试 快速排序---");
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}

