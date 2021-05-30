package lanqiao.xunlian;

import java.util.Scanner;

/**
 * description:输入正整数n，判断从1到n之中，数字1一共要出现几次。例如1123这个数，则出现了两次1。例如15，那么从1到15之中，一共出现了8个1。
 *
 * @author RenShiWei
 * Date: 2020/9/25 11:16
 **/
public class 一的个数 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        solve2(n);
    }

    public static void solve1(int n) {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    temp++;
                }
            }
        }
        System.out.println(temp);
    }

    public static void solve2(int n) {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t >= 1) {
                if (t % 10 == 1) {
                    temp++;
                }
                t /= 10;
            }
        }
        System.out.println(temp);
    }


}

