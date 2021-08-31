package offer;

/**
 * description:斐波那契数列
 * f(n) = 0; n=0
 * f(n) = 1; n=1
 * f(n) = f(n-1) + f(n-2); n>1
 *
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）？。
 * n级台阶的跳法： f(n) = f(n-1) + f(n-2)
 * 这种方法其实就是 【斐波那契数列】
 *
 * @author RenShiWei
 * Date: 2021/8/31 11:03
 **/
public class Fibonacci10 {

    /**
     * 递归实现（效率比较低，有大量重复的计算，不推荐）
     */
    int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 循环实现
     */
    int fibonacciLoop(int n) {
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
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        Fibonacci10 f = new Fibonacci10();
        System.out.println(f.fibonacciLoop(45));
    }


}

