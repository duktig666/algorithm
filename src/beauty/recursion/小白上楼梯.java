package beauty.recursion;

import java.util.Scanner;

/**
 * 功能描述：算法——小白上楼梯
 * 楼梯有n阶，小白一次可以上1阶、2阶或3阶
 * 实现一个方法，计算小白有多少种走完楼梯的方式
 *
 * @author RenShiWei
 * Date: 2020/3/11 15:58
 **/
public class 小白上楼梯 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    static int f ( int n ) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2) + f(n - 3);
    }


    /* 深入递归

         有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
         请实现一个方法，计算小孩有多少种上楼的方式。
         为了防止溢出，请将结果Mod 1000000007

         给定一个正整数int n，请返回一个数，代表上楼的方式数。
         保证n小于等于100000。

         使用迭代法递推
     */
    static final int mod = 1000000007;

    static int recursion ( int n ) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x1 = 1, x2 = 2, x3 = 4;
        for (int i = 4; i <= n; i++) {
            int x_1 = x1;
            x1 = x2 % mod;
            x2 = x3 % mod;
            //新的x3
            x3 = ((x1 + x2) % mod + x_1) % mod;
        }
        return x3;

    }

}

