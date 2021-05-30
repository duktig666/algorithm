package lanqiao.xunlian;

import java.util.Scanner;

/**
 * description:
 * 两个数的乘积 = 最大公约数 x 最小公倍数
 *
 * @author RenShiWei
 * Date: 2020/8/31 16:13
 **/
public class 最小公倍数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(minNumber1(m, n));
        System.out.println(minNumber2(m, n));
        System.out.println(m * n / minNumber1(m, n));

    }

    /**
     * 方法一： 遍历法求最大公约数
     *
     * @return 最大公约数
     */
    public static int minNumber1(int a, int b) {
        int temp = 0;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                temp = i;
            }
        }
        return temp;
    }

    /**
     * 方法一： 辗转相除法求最大公约数
     *
     * @return 最大公约数
     */
    public static int minNumber2(int a, int b) {
        int temp = 1;
        do{
            temp = a % b ;
            a = b;
            b = temp;
            /*
            辗转相除法
            a对b取余，b赋值给a 余数赋值给b，，直到 b == 0
             */
        }while(b != 0);
        return a;
    }


}

