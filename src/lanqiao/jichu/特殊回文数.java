package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 16:31
 **/
public class 特殊回文数 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int temp = n - (i + j) * 2;
                if (temp >= 0 && temp < 10) {
                    System.out.println(i * 10000 + j * 1000 + temp * 100 + j * 10 + i);
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if ((i + j + k) * 2 == n) {
                        System.out.println(i * 100000 + j * 10000 + k * 1000 + k * 100 + j * 10 + i);
                    }
                }
            }
        }
    }

    void f2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 10000; i <= 999999; i++) {
            if (i < 100000) {
                int g = i / 1 % 10;			//个位数字
                int s = i / 10 % 10;		//十位数字
                int b = i / 100 % 10;		//百位数字
                int q = i / 1000 % 10;		//千位数字
                int w = i / 10000 % 10;		//万位数字
                if (g == w && s == q && g+s+b+q+w == n) {
                    System.out.println(i);
                }
            }else {
                int g = i / 1 % 10;			//个位数字
                int s = i / 10 % 10;		//十位数字
                int b = i / 100 % 10;		//百位数字
                int q = i / 1000 % 10;		//千位数字
                int w = i / 10000 % 10;		//万位数字
                int sw = i / 100000 % 10;		//十万位数字
                if (g == sw && s == w && b == q && g+s+b+q+w+sw == n) {
                    System.out.println(i);
                }
            }
        }
    }

}

