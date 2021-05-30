package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 * 问题描述
 * 　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
 * 　　例如：
 * 　　A =
 * 　　1 2
 * 　　3 4
 * 　　A的2次幂
 * 　　7 10
 * 　　15 22
 * 输入格式
 * 　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
 * 　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
 * 输出格式
 * 　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
 * 样例输入
 * 2 2
 * 1 2
 * 3 4
 * 样例输出
 * 7 10
 * 15 22
 *
 * @author RenShiWei
 * Date: 2020/6/1 16:34
 **/
public class 矩阵乘法 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[][] arrA = new int[m][s];
        int[][] arrB = new int[s][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < s; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }
        System.out.println("A-----------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(arrA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("B-----------");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arrB[i][j] + " ");
            }
            System.out.println();
        }
        //算法
        int[][] arrC = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < s; k++) {
                    arrC[i][j] += arrA[i][k] * arrB[k][j];
                }
            }
        }
        //输出
        System.out.println("C-----------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arrC[i][j] + " ");
            }
            System.out.println();
        }
    }

}

