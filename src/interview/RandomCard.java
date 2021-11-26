package interview;

import java.util.Arrays;

/**
 * description: 随机洗牌
 *
 * @author RenShiWei
 * Date: 2021/11/26 9:48
 **/
public class RandomCard {

    /**
     * 随机洗牌算法
     *
     * @param arr 待洗牌
     */
    public static void randomCard(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            swap(arr, i, (int) (Math.random() * n));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        randomCard(arr);
        System.out.println(Arrays.toString(arr));
    }

}

