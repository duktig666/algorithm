package leetcode.matrix;

import java.util.Arrays;

/**
 * description: 62.不同路径  @see https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * m*n的矩阵左上角 到 右下角，每次走一步，有多少条不同的路径
 * <p>
 *
 * @author RenShiWei
 * Date: 2021/8/30 16:10
 **/
public class Path_62 {

    /**
     * 每一格的路径由其上一格和左一格决定 —— 动态规划
     * -动态方程:dp [i][j] = dp [i-1][j] + dp[i][j-1]
     * -注意:对于第一行dp[0][j]，或者第一列dp[i][0]，由于都是在边界，所以只能为1
     * 第一行和第一列的值都为1，其余各自的值 = 左边的格子可能路径 + 右边格子的可能路径 ， 遍历求和
     * 时间复杂度 O(m*n)  空间复杂度 O(m*n)
     * 详情参看 @see https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
     *
     * @param m /
     * @param n /
     * @return 路径数量
     */
    public int uniquePaths(int m, int n) {
        // 辅助矩阵，记录每到一个格子的可能路径
        int[][] help = new int[m][n];
        // 将第一列边界设置为1
        for (int i = 0; i < m; ++ i) {
            help[i][0] = 1;
        }
        //将第一行的边界设置为1
        for (int j = 0; j < n; ++ j) {
            help[0][j] = 1;
        }
        // 利用矩阵计算路径情况
        for (int i = 1; i < m; ++ i) {
            for (int j = 1; j < n; ++ j) {
                // 当前格子可能的路径 = 左边格子的路径 + 上边格子的路径
                help[i][j] = help[i - 1][j] + help[i][j - 1];
            }
        }
        // 最右下角通过动态规划计算的结果即为最终答案
        return help[m - 1][n - 1];
    }

    /**
     * 动态规划，优化一
     * 上一个方法的题解，需要用到 辅助矩阵 来进行，空间复杂度为 O（m*n），可优化
     * <p>
     * 优化：其实每次有效数据只是当前行和上一行的数据，所有用两个数组来存储即可。 时间复杂度 O(2n) ≈O(n)
     *
     * @param m /
     * @param n /
     * @return 路径数量
     */
    public int uniquePaths2(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        //边界行和列 填充1
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; ++ i) {
            for (int j = 1; j < n; ++ j) {
                // cur[j - 1] 为左边格子 pre[j]为上边格子
                cur[j] = cur[j - 1] + pre[j];
            }
            // 将当前行的值赋给上一行，然后进入下一次循环
            pre = cur.clone();
        }
        // 循环结束后 pre 即为最后一行的数据
        return pre[n - 1];
    }

    /**
     * 动态规划，优化二
     * cur[j] += cur[j-1] 即 cur[j] = cur[j-1] + cur[j] 未赋值之前右边的cur[j] 始终表示当前行第i行的上一行第j列的值，
     * 赋值之后左边的cur[j]表示当前行第i行第j列的值
     * <p>
     * 和优化一差不多，只是少了个 pre数组
     *
     * @param m /
     * @param n /
     * @return 路径数量
     */
    public int uniquePaths3(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Path_62 path = new Path_62();
        System.out.println("---动态规划测试---");
        System.out.println(path.uniquePaths(3, 7));
        System.out.println(path.uniquePaths(1, 1));
        System.out.println(path.uniquePaths(3, 2));
        System.out.println("---动态规划优化一测试---");
        System.out.println(path.uniquePaths2(3, 7));
        System.out.println(path.uniquePaths2(1, 1));
        System.out.println(path.uniquePaths2(3, 2));
        System.out.println("---动态规划优化二测试---");
        System.out.println(path.uniquePaths3(3, 7));
        System.out.println(path.uniquePaths3(1, 1));
        System.out.println(path.uniquePaths3(3, 2));
    }


}

