package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/28 16:24
 **/
public class Torry的困惑 {

    public static void main ( String[] args ) {
        int n = new Scanner(System.in).nextInt();
        int res = 1;
        for (int i = 2; i < 100000; i++) {
            //如果是素数
            if (isPrime(i)) {
                //累乘
                res = res * i % 50000;
                n--;
                if (n == 0) {
                    break;
                }
            }
        }
        System.out.println(res);
    }

    /**
     * 测试n是否为素数
     */
    public static boolean isPrime ( long num ) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

