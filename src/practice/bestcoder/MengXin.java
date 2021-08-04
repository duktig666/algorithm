package practice.bestcoder;

import java.util.Scanner;

/**
 * description:
 * Problem Description
 * 给定两个正整数 a,ba,b，求最小和最大的 cc 满足 a \bmod c=b \bmod camodc=bmodc，满足 c-1c−1 为正整数，且 c \le \max(a,b)c≤max(a,b)。
 * <p>
 * 其中的 mod 表示取模运算。
 * <p>
 * Input
 * 本题有多组测试数据。
 * <p>
 * 第一行一个数 TT (1 \le T \le 10001≤T≤1000) 表示一共有 TT 组数据。对于每一组数据，输入一行两个数 a,ba,b (1 \le a,b \le 10000000001≤a,b≤1000000000)。
 * <p>
 * Output
 * 对每组数据，输出一行两个数分别表示最小与最大的 cc，如果不存在满足题意的 cc，则输出一行两个 -1−1。
 * <p>
 * Sample Input
 * 5
 * 2 3
 * 4 6
 * 14 64
 * 114 514
 * 1919 810
 * Sample Output
 * Copy
 * -1 -1
 * 2 2
 * 2 50
 * 2 400
 * 1109 1109
 *
 * @author RenShiWei
 * Date: 2021/7/31 14:13
 **/
public class MengXin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int min = - 1, max = - 1;
            for (int i = 2; i < Math.max(a, b); i++) {
                if (a % i == b % i) {
                    if (min == - 1) {
                        min = i;
                    }
                    max = i;
                }
            }
            System.out.println(min + " " + max);
        }
    }

}

