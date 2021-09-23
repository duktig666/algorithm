package beauty.recursion;

/**
 * 功能描述：算法——高效求a的n次幂
 * 目前先只考虑 为正数的次幂
 *
 * @author RenShiWei
 * Date: 2020/3/12 14:44
 **/
public class 高效求a的n次幂 {

    /**
     * 功能描述：原生方式实现题解
     */
    static int pow ( int a, int n ) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= a;
        }
        return res;
    }

    /**
     * 高效实现
     */
    static int powEfficient ( int a, int n ) {
        if (n == 0) {
            return 1;
        }
        int res = a;
        int ex = 1;
        //左移一位相当于乘以2
        while ((ex << 1) <= n) {
            res = res * res;
            ex <<= 1;
        }
        //每递归一次，直到a的幂不能在乘以2为止
        return res * powEfficient(a, n - ex);
    }

    public static void main ( String[] args ) {
        System.out.println(pow(2, 10));
        System.out.println(powEfficient(2, 10));
    }

}

