package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 17:26
 **/
public class 时间转换 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int h = t / 3600;
        int m = t % 3600 / 60;
        int s = t % 60;
        System.out.println(h + ":" + m + ":" + s);
    }
}

