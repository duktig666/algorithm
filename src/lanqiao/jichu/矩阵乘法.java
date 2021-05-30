package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/21 15:50
 **/
public class 矩阵乘法 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arrA = new int[N][N];
        int[][] arrB = new int[N][N];
        //输入
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrA[i][j] = arrB[i][j] = sc.nextInt();
            }
        }
        //算法
        if (M == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        } else if (M == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arrB[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (int m = 1; m < M; m++) {
                int[][] temp = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int sum = 0;
                        for (int k = 0; k < N; k++) {
                            sum += arrA[i][k] * arrB[k][j];
                        }
                        temp[i][j] = sum;
                    }
                }
                arrB = temp;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arrB[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}

