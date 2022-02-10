package leetcode.codetop;

/**
 * description: https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author RenShiWei
 * Date: 2022/2/7 20:24
 **/
public class codetop35_爬楼梯_70 {

    /**
     * 方法一：
     * 递归解题 （超出时间限制 xxxxx）
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 备忘录
    int[] memo;

    /**
     * 方法二：记忆化 递归
     */
    public int climbStairs2(int n) {
        memo = new int[n + 1];
        return dp(n);
    }

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    int dp(int n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }

    /**
     * 方法三：
     * 动态规划解题
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 方法四：
     * 动态规划 优化 —— 滚动数组
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

