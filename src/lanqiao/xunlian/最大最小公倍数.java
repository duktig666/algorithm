package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 * 多个数相除等于整数：最小公倍数为这几个数的最大数
 * 多个数相除不等于整数：最小公倍数是最小公因数的乘积
 * <p>
 * 数学知识:如果三个数互为质数,那么这三个数的乘积便为它们的最小公倍数。
 * <p>
 * 因为本题目中要求最小公倍数的最大值,那么可以直接从N向前看,找三个连续的互为质数的数,那么它们的乘积便是1~N最小公倍数的最大值。
 * 有以下二种情况。
 * (1)、当N为奇数时,那么N,N-1,N-2互为质数,很明显N*N-1*N-2是1~N最小公倍数的最大值。
 * (2)、当N为偶数时,且能被3整除时,N-1,N-2,N-3互质,此时N-1*N-2*N-3是1~N最小公倍数的最大值；当N为偶数时,但不能被3整除时,N,N-1,N-3互质,此时N*N-1*N-3是1~N最小公倍数的最大值。
 *
 * @author RenShiWei
 * Date: 2020/5/27 16:15
 **/
public class 最大最小公倍数 {

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long max = 0;
        if (n <= 2) {
            max = n;
        } else if (n % 2 == 1) {
            //三个数为奇奇偶，不能被3整除，互为质数
            //当N为奇数时,那么N,N-1,N-2互为质数,很明显N*N-1*N-2是1~N最小公倍数的最大值
            max = n * (n - 1) * (n - 2);
        } else {
            //当N为偶数时
            if (n % 3 == 0) {
                //可以被3整除是特殊情况
                max = (n - 1) * (n - 2) * (n - 3);
            } else {
                max = n * (n - 1) * (n - 3);
            }
        }
        System.out.println(max);
    }
}

