package beauty.test.juzhen;

/**
 * 功能描述：算法——顺时针打印二维数组（转圈打印矩阵）
 * 例如：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 打印结果为： 1， 2， 3， 4， 8， 12， 16， 15， 14， 13， 9，5， 6， 7， 11， 10
 * 要求】 额外空间复杂度为O(1)。
 *
 * @author RenShiWei
 * Date: 2020/4/1 17:09
 **/
public class 顺时针打印二维数组 {

    public static void spiralOrderPrint ( int[][] matrix ) {
        //初始化左上角和右下角的坐标
        int leftUpRow = 0, leftUpColumn = 0, rightDownRow = matrix.length - 1, rightDownColumn = matrix[0].length - 1;

        while (leftUpRow <= rightDownRow && leftUpColumn <= rightDownColumn) {
            //循环调用，每次打印一圈
            printEdge(matrix, leftUpRow++, leftUpColumn++, rightDownRow--, rightDownColumn--);
        }

    }

    //每次打印一圈数组
    static void printEdge ( int[][] arr, int leftUpRow, int leftUpColumn, int rightDownRow, int rightDownColumn ) {

        if (leftUpRow == rightDownRow) {
            //如果只有一行
            for (int i = leftUpColumn; i < rightDownColumn; i++) {
                System.out.print(arr[0][i] + " ");
            }
        } else if (leftUpColumn == rightDownColumn) {
            //如果只有一列
            for (int i = leftUpRow; i < rightDownRow; i++) {
                System.out.print(arr[i][0] + " ");
            }
        } else {
            //如果是矩阵
            int currentRow = leftUpRow, currentColumn = leftUpColumn;
            //打印矩阵上边元素
            while (currentColumn != rightDownColumn) {
                System.out.print(arr[leftUpRow][currentColumn++] + " ");
            }
            //打印矩阵右边元素
            while (currentRow != rightDownRow) {
                System.out.print(arr[currentRow++][rightDownColumn] + " ");
            }
            //打印矩阵下边元素
            while (currentColumn != leftUpColumn) {
                System.out.print(arr[rightDownRow][currentColumn--] + " ");
            }
            //打印矩阵左边元素
            while (currentRow != leftUpRow) {
                System.out.print(arr[currentRow--][leftUpColumn] + " ");
            }
        }
    }

    public static void main ( String[] args ) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }
}

