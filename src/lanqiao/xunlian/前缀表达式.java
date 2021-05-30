package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/6/6 15:47
 **/
public class 前缀表达式 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();
        switch (str) {
            case "+":
                System.out.println(add(a, b));
                break;
            case "-":
                System.out.println(del(a, b));
                break;
            case "*":
                System.out.println(cheng(a,b));
                break;
            case "/":
                System.out.println(chu(a,b));
                break;
            default:

        }
    }

    private static int add ( int a, int b ) {
        return a + b;
    }

    private static int del ( int a, int b ) {
        return a - b;
    }

    private static int cheng ( int a, int b ) {
        return a * b;
    }

    private static int chu ( int a, int b ) {
        return a / b;
    }
}

