package offer;

/**
 * description:斐波那契数列
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

