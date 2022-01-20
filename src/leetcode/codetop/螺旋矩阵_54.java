package leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author RenShiWei
 * Date: 2022/1/11 8:52
 **/
public class 螺旋矩阵_54 {

    /**
     * 计算层数，然后按层循环向内打印
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历的层数
        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int k = (Math.min(m, n) + 1) / 2;

        //从外部向内部遍历，逐层打印数据
        while (i < k) {
            // 向右打印
            for (int j = i; j < n - i; j++) {
                res.add(matrix[i][j]);
            }
            // 向下打印
            for (int j = i + 1; j < m - i; j++) {
                res.add(matrix[j][(n - 1) - i]);
            }
            // 向左打印
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {
                res.add(matrix[(m - 1) - i][j]);
            }
            // 向上打印
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }

        return res;
    }

}

