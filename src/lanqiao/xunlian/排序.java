package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/6/9 18:38
 **/
public class 排序 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = arr.length - 1; i > 0; i--) {
            //循环，每次循环，最大的数排在最后一位
            for (int j = 0; j < i; j++) {
                //从小到大排序。如果左边大。两个元素交换位置
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap ( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

