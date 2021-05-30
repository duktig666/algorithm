package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/18 17:45
 **/
public class 字符串对比 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if (s1.length() != s2.length()) {
            System.out.println(1);
        } else {
            if (s1.equals(s2)) {
                System.out.println(2);
            } else if (s1.equalsIgnoreCase(s2)) {
                System.out.println(3);
            } else {
                System.out.println(4);
            }
        }
    }

}

