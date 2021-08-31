package leetcode.other;

/**
 * description: @see https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author RenShiWei
 * Date: 2021/8/31 14:13
 **/
public class 斐波那契数列取余 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // 前一项
        int fibOne = 1;
        //前两项
        int fibTwo = 0;
        // 第n项斐波那契数列的值
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = (fibOne + fibTwo) % 1000000007;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }

}

