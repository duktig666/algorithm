package offer;

/**
 * description: 剑指offer14题——剪绳子 @see https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * @author RenShiWei
 * Date: 2021/9/15 10:19
 **/
public class CuttingRope14 {

    /**
     * 动态规划实现
     */
    public int cuttingRopeByDP(int n) {
        /*
         *  三种特殊情况：
         *  1、长度为1时，没法剪，最大乘积为0
         *  2、长度为2时，最大乘积为1 × 1 = 1
         *  3、长度为3时，最大乘积为1 × 2 = 2
         */
        if (n <= 3) {
            return n - 1;
        }

        //创建数组存储子问题最优解 存储[0,n] dp[i]表示剪长度为i的绳子所能得到的最大乘积
        int[] dp = new int[n + 1];

        /*
         *  上面分析过长度小于等于3时存在的特殊情况，所以当绳子剪过之后，有一段长度小于等于3时，就不应该继续剪，否则乘积就会变小
         *  则在动态规划数组中，小于等于3的索引所指的元素应该等于其索引的值，代表剪过的绳子到这长度就不要继续剪了
         */
        for (int i = 0; i <= 3; i++) {
            dp[i] = i;
        }

        // 开始求解每一个绳子长度的最优解，去掉特殊情况从4开始
        for (int i = 4; i <= n; i++) {
            // j表示将绳子剪成长度为j和i-j的两段（j只需要遍历到i/2就可以了，两边对称的。比如4剪成 1|3 和 3|1 结果是一样的）
            for (int j = 1; j <= i / 2; j++) {
                // dp[i]记录当前长度绳子剪过之后的最大乘积
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    /**
     * 动态规划——剑指offer实现
     */
    public int cuttingRopeByDPDetail(int n) {
        /*
         *  三种特殊情况：
         *  1、长度为1时，没法剪，最大乘积为0
         *  2、长度为2时，最大乘积为1 × 1 = 1
         *  3、长度为3时，最大乘积为1 × 2 = 2
         */
        if (n <= 3) {
            return n - 1;
        }
        //创建数组存储子问题最优解 存储[0,n] dp[i]表示剪长度为i的绳子所能得到的最大乘积
        int[] dp = new int[n + 1];
        /*
         *  上面分析过长度小于等于3时存在的特殊情况，所以当绳子剪过之后，有一段长度小于等于3时，就不应该继续剪，否则乘积就会变小
         *  则在动态规划数组中，小于等于3的索引所指的元素应该等于其索引的值，代表剪过的绳子到这长度就不要继续剪了
         */
        for (int i = 0; i <= 3; i++) {
            dp[i] = i;
        }
        // 开始求解每一个绳子长度的最优解，去掉特殊情况从4开始
        for (int i = 4; i <= n; i++) {
            // 每个长度的最大值
            int max = 0;
            // j表示将绳子剪成长度为j和i-j的两段（j只需要遍历到i/2就可以了，两边对称的。比如4剪成 1|3 和 3|1 结果是一样的）
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max) {
                    max = temp;
                }
            }
            // dp[i]记录当前长度绳子剪过之后的最大乘积
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * 贪心算法实现 优化后
     */
    public int cuttingRopeByGreedy(int n) {
        /*
         *  三种特殊情况：
         *  1、长度为1时，没法剪，最大乘积为0
         *  2、长度为2时，最大乘积为1 × 1 = 1
         *  3、长度为3时，最大乘积为1 × 2 = 2
         */
        if (n <= 3) {
            return n - 1;
        }
        // 计算绳子每次剪3后的乘积
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        // 最后再乘上不能剪成3的，和可以剪成4（平分的）
        return res * n;
    }

    /**
     * 贪心算法实现 详细
     */
    public int cuttingRopeByGreedyDetail(int n) {
        /*
         *  三种特殊情况：
         *  1、长度为1时，没法剪，最大乘积为0
         *  2、长度为2时，最大乘积为1 × 1 = 1
         *  3、长度为3时，最大乘积为1 × 2 = 2
         */
        if (n <= 3) {
            return n - 1;
        }

        // 尽可能多的，计算绳子每次剪3 的次数
        int threeCount = 0;
        while (n > 4) {
            n -= 3;
            threeCount++;
        }
        return (int) Math.pow(3, threeCount) * n;
    }

    public static void main(String[] args) {
        CuttingRope14 test = new CuttingRope14();
        System.out.println(test.cuttingRopeByGreedyDetail(10)); // 36
    }


}

