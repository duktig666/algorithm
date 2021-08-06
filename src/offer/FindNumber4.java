package offer;

import java.util.Scanner;

/**
 * description:一个矩阵，每一行从左到右递增，每一列从上往下递增。
 * 输入这样的矩阵和整数，判断整数是否存在矩阵当中
 *
 * @author RenShiWei
 * Date: 2021/7/2 11:28
 **/
public class FindNumber4 {

    static boolean findMatrixForNum(int[][] matrix, int num) {
        int i = matrix[0].length - 1, j = 0;
        while (i > 0) {
            if (matrix[0][i] > num) {
                i--;
            } else if (matrix[0][i] == num) {
                return true;
            } else {
                while (j < matrix.length && i > 0) {
                    if (matrix[j][i] < num) {
                        j++;
                    } else if (matrix[j][i] == num) {
                        return true;
                    } else {
                        i--;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入矩阵的行数");
        int m = sc.nextInt();
        System.out.println("输入矩阵的列数");
        int n = sc.nextInt();
        System.out.println("请输入符合条件的矩阵");
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("请输入查找的整数");
        int num = sc.nextInt();
        sc.close();
        System.out.println(findMatrixForNum(matrix, num));
    }


}

