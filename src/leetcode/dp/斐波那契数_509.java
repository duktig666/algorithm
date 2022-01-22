package leetcode.dp;

/**
 * description: https://leetcode-cn.com/problems/fibonacci-number/
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，
 * 后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * @author RenShiWei
 * Date: 2022/1/22 14:34
 **/
public class 斐波那契数_509 {

    /**
     * 暴力递归
     */
    public int fib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 带备忘录的递归
     */
    public int fib2(int N) {
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 已经计算过，不用再计算了
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * dp 数组的迭代解法
     */
    public int fib3(int N) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    /**
     * O(1) 每次只记录前两项的值
     */
    public int fib4(int n) {
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


}

