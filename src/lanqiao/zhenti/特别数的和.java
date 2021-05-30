package lanqiao.zhenti;

import java.util.Scanner;

/**
 * description:
 * 蓝桥杯第十届题F
 *
 * @author RenShiWei
 * Date: 2020/10/8 15:07
 **/
public class 特别数的和 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean check(int n) {
        String s = Integer.toString(n);
        if (s.contains("2") || s.contains("0") || s.contains("1") || s.contains("9")) {
            return s.charAt(0) != '0';
        }
        return false;
    }


}

