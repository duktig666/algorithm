package beauty.test.quicksort;

import beauty.utils.Util;

/**
 * 功能描述：算法——奇数在前偶数在后
 * 一个数组中，将奇数放在前边，偶数放在右边，可以不进行排序
 * 思路：
 * 1.归并
 * 两个指针，遇到奇数放到左边，左指针++；遇到偶数放到右边，右指针--
 * 但是需要重新开辟一个数组，空间复杂度为O(n)
 * 2.快排
 * 两个指针，左边指针找偶数，右边指针找奇数，如果找到，交换两个指针所对应的数
 * 当两个指针交错时，结束
 *
 * @author RenShiWei
 * Date: 2020/3/23 20:19
 **/
public class 奇数在前偶数在后 {

    /**
     * 使用归并思想解决
     */
    static int[] setArr(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int ji = 0, ou = arr.length - 1;
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                //如果是偶数
                help[ou] = arr[i];
                ou--;
            } else {
                //如果是奇数
                help[ji] = arr[i];
                ji++;
            }
        }
        return help;
    }

    /**
     * 使用快排思想解决
     */
    static int[] setArr2(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 != 0) {
                left++;
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
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
        int[] arr = {256, 5, 6, 4, 8, 1, 65};
        int[] arr2 = {};
        Util.printArr(setArr(arr));
        Util.printArr(setArr2(arr));
    }

}

