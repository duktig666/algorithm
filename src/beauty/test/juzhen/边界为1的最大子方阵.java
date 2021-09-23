package beauty.test.juzhen;

/**
 * 功能描述：算法——边界为1的最大子方阵
 * >给定一个NxN的矩阵matrix,在这个矩阵中,只有0和1两种值,
 * 返回边框全是1的最大正方形的边长长度。
 * 例如:
 * {0,1,1,1,1},
 * {0,1,0,0,1},
 * {0,1,0,0,1},
 * {0,1,1,1,1},
 * {0,1,0,1,1}
 * <p>
 * 其中,边框全是1的最大正方形的大小是4*4 ,返回4
 *
 * @author RenShiWei
 * Date: 2020/4/1 20:28
 **/
public class 边界为1的最大子方阵 {

    /**
     * 原生遍历实现
     * 时间复杂度  N^4
     */
    static int solve ( int[][] matrix ) {
        int n = matrix.length;
        //从大到小遍历，寻找满足矩阵的边长度
        while (n-- > 0) {
            for (int i = 0; i < matrix.length; i++) {
                //边界处理
                if (i + n > matrix.length) {
                    break;
                }
                l3:
                for (int j = 0; j < matrix.length; j++) {
                    //边界处理
                    if (j + n > matrix.length) {
                        break;
                    }
                    //定义扫描行列的指针
                    int row = i, column = j;
                    //扫描最上边是否存在0
                    while (column < j + n) {
                        if (matrix[row][column++] == 0) {
                            continue l3;
                        }
                    }
                    //扫描到最后多+一次，需要恢复
                    column--;

                    //扫描最右边是否存在0
                    while (row < i + n) {
                        if (matrix[row++][column] == 0) {
                            continue l3;
                        }
                    }
                    row--;

                    //扫描最下边是否存在0
                    while (column >= j) {
                        if (matrix[row][column--] == 0) {
                            continue l3;
                        }
                    }
                    column++;

                    //扫描最左边是否存在0
                    while (row >= i) {
                        if (matrix[row--][column] == 0) {
                            continue l3;
                        }
                    }
                    //已经走完，这步恢复是多余的
                    //row++;
                }
                return n;
            }
        }
        return 0;
    }

    /**
     * 优化
     */
    /**
     * 辅助三维数组
     */
    static int[][][] rec;

    static int solve2 ( int[][] matrix ) {
        int n = matrix.length;
        //从大到小遍历，寻找满足矩阵的边长度
        while (n-- > 0) {
            for (int i = 0; i < matrix.length; i++) {
                //边界处理
                if (i + n > matrix.length) {
                    break;
                }
                l3:
                for (int j = 0; j < matrix.length; j++) {
                    //边界处理
                    if (j + n > matrix.length) {
                        break;
                    }
                    if (check(i, j, n)) {
                        return n;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean check ( int i, int j, int n ) {


        return false;
    }

    private static void help ( int[][] matrix ) {
        int n = matrix.length;
        rec = new int[n][n][2];
        int row = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int value = matrix[i][j];
                if (value == 1) {
                    if (j == n - 1) {
                        //右侧连续1的个数
                        rec[row][j][0] = 1;
                    } else {
                        rec[row][j][0] = rec[row][j + 1][0] + 1;
                    }
                }
            }
        }
        row--;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int value = matrix[i][j];
                if (value == 1) {
                    if (j == n - 1) {
                        //右侧连续1的个数
                        rec[i][j][0] = 1;
                    } else {
                        rec[i][j][0] = rec[i][j + 1][0] + 1;
                    }
                    //往下走1的个数
                    rec[i][j][1] = rec[i][j + 1][1] + 1;
                }
            }
        }
    }

    public static void main ( String[] args ) {
        int[][] matrix = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 0, 1, 1}
        };
        int[][] matrix2 = {
                {1, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };
        System.out.println(solve(matrix));
        System.out.println(solve(matrix2));

        //方法二
        help(matrix);
        System.out.println(solve2(matrix));

    }


}

