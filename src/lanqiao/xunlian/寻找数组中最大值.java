package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/28 16:03
 **/
public class 寻找数组中最大值 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = arr[0],l=0;
        for (int i = 1; i < n; i++) {
            if (arr[i]>arr[i-1]){
                max=arr[i];
                l=i;
            }
        }
        System.out.println(max+" "+l);
    }

}

