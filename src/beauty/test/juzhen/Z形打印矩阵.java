package beauty.test.juzhen;

/**
 * 功能描述：算法——Z形打印矩阵
 * * “之” 字形打印矩阵
 * * 【题目】 给定一个矩阵matrix， 按照“之” 字形的方式打印这
 * * 个矩阵， 例如：
 * * 1 2 3 4
 * * 5 6 7 8
 * * 9 10 11 12
 * * “之” 字形打印的结果为： 1， 2， 5， 9， 6， 3， 4， 7， 10， 11，8， 12
 * * 【要求】 额外空间复杂度为O(1)
 *
 * @author RenShiWei
 * Date: 2020/4/1 18:25
 **/
public class Z形打印矩阵 {

    static void printZ ( int[][] matrix ) {
        int currentRow = 0, endRow = matrix.length;
        int currentColumn = 0, endColumn = matrix[0].length;
        //是否为从左下到右上，上坡路打印
        boolean leftToRight = true;
        while (currentRow < endRow && currentColumn < endColumn) {
            //从左下到右上打印
            if (leftToRight) {
                System.out.print(matrix[currentRow][currentColumn] + " ");
                if (currentRow == 0 && currentColumn < endColumn - 1) {
                    //在第一行，列未到边界，向右边走
                    leftToRight = false;
                    currentColumn++;
                } else if (currentColumn == endColumn - 1) {
                    //在最后一列，向下走
                    leftToRight = false;
                    currentRow++;
                } else {
                    //在中间，往上走
                    currentRow--;
                    currentColumn++;
                }
            } else {
                //走下坡路
                System.out.print(matrix[currentRow][currentColumn] + " ");
                if (currentColumn == 0 && currentRow < endRow - 1) {
                    //走到第一列只能往下走
                    leftToRight = true;
                    currentRow++;
                } else if (currentRow==endRow - 1) {
                    //到最后一行，只能往右走
                    leftToRight = true;
                    currentColumn++;
                } else {
                    //在中间，往下走
                    currentRow++;
                    currentColumn--;
                }
            }


        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printZ(matrix);

    }
}

