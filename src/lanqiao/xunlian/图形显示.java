package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/6/9 18:12
 **/
public class 图形显示 {


    public static void main ( String[] args ) {
        int n = new Scanner(System.in).nextInt();
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

}

