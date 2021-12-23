package interview;

import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/triangle/
 *
 * @author RenShiWei
 * Date: 2021/12/22 10:19
 **/
public class 三角形最小路径和_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        // 二维数组记录当前路径和
        int[][] temp = new int[m][m];
        temp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            // 计算当前行第一个元素值（第一个元素上一行，左边无元素）
            temp[i][0] = temp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                // 依次往后计算，当前层路径的最小和
                temp[i][j] = Math.min(temp[i - 1][j - 1], temp[i - 1][j]) + triangle.get(i).get(j);
            }
            // 计算最后一格的值
            temp[i][i] = temp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // 最后一行对比哪一个值最小
        int minSum = temp[m - 1][0];
        for (int i = 1; i < m; ++ i) {
            minSum = Math.min(minSum, temp[m - 1][i]);
        }
        return minSum;
    }

}

