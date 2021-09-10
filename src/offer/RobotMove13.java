package offer;

/**
 * description: 剑指offer13题——机器人的运动范围 @see https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * @author RenShiWei
 * Date: 2021/9/10 8:57
 **/
public class RobotMove13 {

    public int movingCount(int m, int n, int k) {
        boolean[] visited = new boolean[m * n];
        int i = 0, j = 0;
        return backtrack(m, n, k, i, j, visited);
    }

    private int backtrack(int m, int n, int k, int i, int j, boolean[] visited) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i * n + j]) {
            return 0;
        }
        //机器人到达格子的数量统计
        int count = 0;
        if (getDigitSum(i) + getDigitSum(j) <= k) {
            visited[i * n + j] = true;
            count = 1 + backtrack(m, n, k, i + 1, j, visited) +
                    backtrack(m, n, k, i - 1, j, visited) +
                    backtrack(m, n, k, i, j + 1, visited) +
                    backtrack(m, n, k, i, j - 1, visited);
        }
        return count;
    }

    /**
     * 计算数字各个位数之和
     */
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotMove13 test = new RobotMove13();
        System.out.println(test.movingCount(2, 3, 1));
        System.out.println(test.movingCount(3, 1, 0));
    }

}

