package leetcode.dp;

import java.util.Arrays;

/**
 * description: https://leetcode-cn.com/problems/minimum-falling-path-sum/
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是
 * (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * @author RenShiWei
 * Date: 2022/1/22 16:37
 **/
public class 下降路径最小和_931 {

    /** 备忘录 */
    private int[][] memo;

    /**
     * 主函数
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 记录结果
        int res = Integer.MAX_VALUE;
        // 备忘录里的值初始化为 66666，在 [-10000, 10000] 之外即可
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在 matrix[n-1] 的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        // 1、索引合法性检查
        if (i < 0 || j < 0 ||
                i >= matrix.length ||
                j >= matrix[0].length) {

            return 99999;
        }
        // 2、base case
        if (i == 0) {
            // 从 matrix[0][j] 开始下落，所以返回
            return matrix[0][j];
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 进行状态转移
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j + 1)
        );

        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}

