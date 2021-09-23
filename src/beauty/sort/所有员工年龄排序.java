package beauty.sort;

import java.util.Scanner;

/**
 * 功能描述：算法——所有员工年龄排序
 * ➢公司现在要对几万员工的年龄进行排序,因为公司员工的人数非常
 * 多,所以要求排序算法的效率要非常高,你能写出这样的程序吗
 * ➢输入:输入可能包含多个测试样例,对于每个测试案例,
 * -输入的第- -行为- 一个整数n(1<= n<=1000000) :代表公司内员工的人数。
 * -输入的第二行包括n个整数:代表公司内每个员工的年龄。其中，员工年龄
 * age的取值范围为(1<=age<=99)。
 * ➢输出:对应每个测试案例，
 * -请输出排序后的n个员工的年龄，每个年龄后面有一一个空格 。
 *
 * @author RenShiWei
 * Date: 2020/3/30 21:35
 **/
public class 所有员工年龄排序 {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100];
        while (n-- > 0) {
            int b = sc.nextInt();
            arr[b]++;
        }
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] > 0) {
                System.out.println(i + " ");
                arr[i]--;
            }
        }
    }
}

