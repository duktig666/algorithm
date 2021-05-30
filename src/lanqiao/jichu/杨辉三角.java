package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 * <p>
 * 样例输出
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 *
 * @author RenShiWei
 * Date: 2020/4/16 17:08
 **/
public class 杨辉三角 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //定义二维数组
        int arr[][] = new int[n][n];
        //输出第一行的1
        System.out.println(1);
        for (int i = 1; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            System.out.print(arr[i][0] + " ");
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(arr[i][i]);
        }
    }

}

