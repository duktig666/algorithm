package beauty.sort;

import beauty.utils.Util;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/3/18 18:47
 **/
public class QuickSort {

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    /**
     * 一遍单向扫描法
     */
    private static int partition(int[] arr, int l, int r) {
        //以第一个元素为主元
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            if (arr[less] <= pivot) {
                //如果小于等于主元，左指针继续右移
                less++;
            } else {
                //如果大于主元，当前元素和右侧指针对应的元素交换位置
                swap(arr, less, more);
                more--;
            }
        }
        //左后将主元放在中间的临界值位置
        swap(arr, l, more);
        return more;
    }

    /**
     * 双向扫描法
     */
    private static int partition2(int[] arr, int l, int r) {
        //以第一个元素为主元
        int pivot = arr[l];
        //扫描指针
        int less = l + 1;
        //右侧指针
        int more = r;
        while (less <= more) {
            while (less <= more && arr[less] <= pivot) {
                less++;
            }
            while (less <= more && arr[more] > pivot) {
                more--;
            }
            //上面两个循环都完毕，说明此时左边元素大于主元，右边元素小于主元，需要进行交换
            if (less <= more) {
                swap(arr, less, more);
            }
        }
        //最后将主元放在左右两边的临界点
        swap(arr, l, more);
        return more;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5, 8, 45, 68};
        quickSort(arr, 0, arr.length - 1);
        Util.printArr(arr);
    }

}

