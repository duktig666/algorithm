package datastructure.sort;

import java.util.Arrays;

/**
 * description:冒泡排序
 *
 * @author RenShiWei
 * Date: 2020/2/9 17:42
 **/
public class BubbleSort {

    /**
     * 冒泡排序优化——最佳情况T(n) = O(n)
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //从数组末尾每次减1（排序一次，减少一个数组元素的排序）
        for (int i = arr.length - 1; i > 0; i--) {
            boolean isSwap = true;
            //循环，每次循环，最大的数排在最后一位
            for (int j = 0; j < i; j++) {
                //从小到大排序。如果左边大。两个元素交换位置
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = false;
                }
            }
            if (isSwap) {
                return;
            }
        }
    }

    /**
     * 功能描述： 调换两个元素在数组中的位置
     *
     * @author RenShiWei
     * Date: 2020/2/9 17:42
     * <p>
     * 定义辅助空间的方法
     * int tmp = arr[i];
     * arr[i] = arr[j];
     * arr[j] = tmp;
     * <p>
     * 位异或运算（^）
     * 运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
     * 比如：8^11.
     * 8转为二进制是1000，11转为二进制是1011.从高位开始比较得到的是：0011.然后二进制转为十进制，就是Integer.parseInt("0011",2)=3;
     * <p>
     * 第一个简单用法是可以用来交换两个基本数据类型的变量的内容
     *     以下是例子：
     *     int f = 50;    二进制 110010
     *     int g = 60;    二进制 111100
     *     f = f^g;   110010，111100——>001110
     *     g = f^g;   001110,111100——>110010  ——>50
     *     f = f^g;   001110,110010——>111100  ——>60
     *     System.out.println(f+" "+g);
     *     输出结果是：60 50
     * <p>
     * 优点：节省辅助空间，降低空间复杂度
     */
    public static void swap(int[] arr, int i, int j) {
        //这种方式还不理解
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 6, 2, 68, 5, 8, 45};
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1, 6, 2, 4, 5, 8, 45, 68, 6};
        bubbleSort.bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        bubbleSort.bubbleSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }


}

