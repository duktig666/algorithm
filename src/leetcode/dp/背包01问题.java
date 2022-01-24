package leetcode.dp;

/**
 * description:
 * 给你一个可装载重量为 `W` 的背包和 `N` 个物品，每个物品有重量和价值两个属性。其中第 `i` 个物品的重量为 `wt[i]`，
 * 价值为 `val[i]`，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举例：
 * 输入：
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * <p>
 * 输出：
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于 `W`，可以获得最大价值 6。
 *
 * @author RenShiWei
 * Date: 2022/1/24 17:45
 **/
public class 背包01问题 {

    /**
     * 0-1 背包问题
     * 动态规划解法
     *
     * @param weight 背包装载重量
     * @param number 背包装载数量
     * @param wt     物品数量数组
     * @param val    物品价值数组
     * @return 最多能装的价值是多少
     */
    public int knapsack(int weight, int number, int[] wt, int[] val) {
        // base case 已初始化  dp[i][w] 表示：对于前 i 个物品，当前背包的容量为 w 时，这种情况下可以装下的最大价值
        int[][] dp = new int[number + 1][weight + 1];

        for (int i = 1; i <= number; i++) {
            for (int w = 1; w <= weight; w++) {
                // 背包装不下
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    /*可装入情况下，装入或者不装入背包，择优
                     * 1. dp[i - 1][w - wt[i - 1]] + val[i - 1],代表：如果装了第 i 个物品，就要寻求剩余重量 w - wt[i-1] 限制下的最大价值，加上第 i
                     * 个物品的价值 val[i-1]
                     * 2. dp[i - 1][w]，代表不装入背包
                     */
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }

        return dp[number][weight];
    }

}

