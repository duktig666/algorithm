package beauty.test.juzhen;

import java.util.Arrays;

/**
 * 功能描述：算法-子矩阵最大累加和
 * ➢给定一个矩阵matrix ,其中的值有正、有负、有0 ,返回子矩阵的
 * 最大累加和。
 * ➢例如, matrix为:
 * -1 1 -1
 * -1 2 2
 * -1 -1 -1
 * <p>
 * 其中最大累加和的子矩阵为:
 * 2 2
 * 所以返回4。
 *
 * @author RenShiWei
 * Date: 2020/4/3 18:24
 **/
public class 子矩阵最大累加和 {

    static int maxSum(int matrix[][]) {
        //起始行
        int beginRow = 0;
        //历史的最大值
        int max = 0;
        //按列求和
        int[] sumRow = new int[matrix[0].length];
        //遍历所有的行
        while (beginRow < matrix.length) {
            //从起始行到i行
            for (int i = beginRow; i < matrix.length; i++) {
                //按行累加
                for (int j = 0; j < matrix[0].length; j++) {
                    sumRow[j] += matrix[i][j];
                }
                //累加完成
                int t = 子数组最大累加和.findMax(sumRow);
                if (t > max) {
                    max = t;
                }
            }
            //另起一行作为起始行，把sum清零
            Arrays.fill(sumRow, 0);
            beginRow++;
        }
        return max;
    }

}

