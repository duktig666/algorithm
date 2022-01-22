package leetcode.dp;

import java.util.Arrays;

/**
 * description: https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author RenShiWei
 * Date: 2022/1/22 15:12
 **/
public class 零钱兑换_322 {


    /**
     * 暴力递归
     *
     * @param coins  可选硬币面值
     * @param amount 目标金额
     * @return 最小硬币数
     */
    public int coinChange1(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp1(coins, amount);
    }

    /**
     * 暴力递归
     */
    int dp1(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return - 1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == - 1) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? - 1 : res;
    }

    //--------------------------------------------------------

    int[] memo;

    /**
     * 带备忘录的递归
     */
    int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        // dp 数组全都初始化为特殊值
        Arrays.fill(memo, - 666);

        return dp2(coins, amount);
    }

    /**
     * 带备忘录的递归
     */
    int dp2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return - 1;
        }
        // 查备忘录，防止重复计算
        if (memo[amount] != - 666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp2(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == - 1) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? - 1 : res;
        return memo[amount];
    }

    //---------------------------最优解-----------------------------

    /**
     * dp 数组的迭代解法
     *
     * @param coins  可选硬币面值
     * @param amount 目标金额
     * @return 最小硬币数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case， dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过（i代表当前的金额）
                if (i < coin) {
                    continue;
                }
                // i - coin 前一个金额需要的个数（找不开情况）
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? - 1 : dp[amount];
    }

}

