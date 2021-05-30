package lanqiao.xunlian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/27 15:46
 **/
public class 区间k大数查询 {

    public static void main ( String[] args ) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            int[] temp=new int[r-l+1];
            l--;
            for (int i = 0; i < temp.length; i++) {
                temp[i]=arr[l++];
            }
            Arrays.sort(temp);
            System.out.println(temp[temp.length-k]);
        }
    }

}

