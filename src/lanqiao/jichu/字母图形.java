package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/16 15:59
 **/
public class 字母图形 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == i) {
                    arr[i][j] = 'A';
                } else {
                    arr[i][j] = (char) ('A' + Math.abs(i - j));
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    void f2 () {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();
        String str = "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < n; i++) {
            System.out.println(str.substring((25 - i), (25 - i + m)));
        }

    }

}

