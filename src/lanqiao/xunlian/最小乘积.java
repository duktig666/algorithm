package lanqiao.xunlian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/28 17:42
 **/
public class 最小乘积 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //多组输入输出
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextInt();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum+=(arr1[i]*arr2[n-i-1]);
            }
            System.out.println(sum);
        }
    }

}

