package beauty.test.juzhen;

import beauty.utils.Util;

/**
 * 功能描述：算法——零所在的行列清零
 * ➢如果矩阵中某个元素为0 ,则将其所在行和列清零
 * 1 2 3 4
 * 5 6 0 8
 * 9 0 11 12
 * 13 14 15  16
 *
 * @author RenShiWei
 * Date: 2020/4/1 18:09
 **/
public class 零所在的行列清零 {

    static void solve(int[][] matrix){
        //记录0所出现的列
        int[] columnRecord=new int[matrix[0].length];
        //记录0所出现的行
        int[] rowRecord=new int[matrix.length];
        for (int i = 0; i < rowRecord.length; i++) {
            for (int j = 0; j < columnRecord.length; j++) {
                if (matrix[i][j]==0){
                    rowRecord[i]=1;
                    columnRecord[j]=1;
                }
            }
        }
        for (int i = 0; i < rowRecord.length; i++) {
            for (int j = 0; j < columnRecord.length; j++) {
                if (rowRecord[i]==1||columnRecord[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main ( String[] args ) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 0, 8}, {9, 0, 11, 12},
                {13, 14, 15, 16}};
        solve(matrix);
        Util.printMatrix(matrix);
    }


}

