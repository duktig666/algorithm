package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/29 15:09
 **/
public class 删除数组零元素 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = compactIntegers(arr, n);
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 删除数组的零
     *
     * @param arr 待删除零的数组
     * @param k   数组的元素个数
     * @return 数组删除0后的元素个数
     */
    public static int compactIntegers(int[] arr, int k) {
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, t++);
            }
        }
        return t;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

