package interview;

import java.util.Scanner;

/**
 * description:输入层数，根据如下规律，计算最后一行值的和（0代表没有数据）
 * <p>
 * 0  0  0  0  0  1  0  0  0  0  0
 * 0  0  0  0  2  1  1  0  0  0  0
 * 0  0  0  3  3  3  2  3  0  0  0
 * 0  0  4  6  6  5  5  3  4  0  0
 * 0  5  10 12 11 10 8  7  4  5  0
 * 6  15 22 23 21 18 15 11 9  5  6
 *
 * @author RenShiWei
 * Date: 2021/11/4 15:16
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class JiaoQianJin20211104 {

    public static void main(String[] args) {
        // 输入层数
        int n = new Scanner(System.in).nextInt();
        // 构建二维数组用来记录值
        int[][] arr = new int[n][2 * n - 1];
        arr[0][n - 1] = 1;
        // 从第二行开始遍历
        for (int i = 1; i < n; i++) {
            // 初始化每行左右特殊的值
            arr[i][n - i - 1] = i + 1;
            arr[i][n + i - 1] = i + 1;
            // j的初始值为，第一个需要进行前一行和计算的值；j的临界条件为右侧的特殊值（行值）
            for (int j = n - i; j < n + i - 1; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j + 1];
            }
        }
        int num = 0;
        //计算最后一行的和
        for (int i = 0; i < arr[0].length; i++) {
            num += arr[n - 1][i];
        }
        // n=6 num=151
        System.out.println(num);
    }

}

