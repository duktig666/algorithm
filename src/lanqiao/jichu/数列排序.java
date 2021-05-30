package lanqiao.jichu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 17:10
 **/
public class 数列排序 {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i++] = sc.nextInt();
        }
        Arrays.sort(arr);
        i = 0;
        while (i < n) {
            System.out.print(arr[i++]+ " ");
        }
    }
}

