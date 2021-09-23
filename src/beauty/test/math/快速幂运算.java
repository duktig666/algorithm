package beauty.test.math;

/**
 * 功能描述：算法——快速幂运算
 *
 * @author RenShiWei
 * Date: 2020/4/14 15:22
 **/
public class 快速幂运算 {

    /**
     * 二进制巧算a的n次方
     */
    static long ex2 ( long n, long m ) {
        long pingFangShu = n;
        long result = 1;
        while (m != 0) {
            //遇到1累乘现在的幂（二进制）
            if ((m & 1) == 1) {
                result *= pingFangShu;
            }
            //每移位一次，幂累积乘方一次
            pingFangShu = pingFangShu * pingFangShu;
            //右移一位
            m >>= 1;
        }
        return result;
    }

    /**
     * 最快速求a的n次方
     * O(lgn)
     */
    static int ex ( int a, int n ) {
        if (n == 1) {
            return 0;
        }
        //表示a的1次方
        int temp = a;
        int res = 1;
        int exponent = 1;
        //指数翻倍
        while ((exponent << 1) < n) {
            temp = temp * temp;
            //指数增加1倍
            exponent = exponent << 1;
        }

        res *= ex(a, n - exponent);

        return res * temp;

    }

}

