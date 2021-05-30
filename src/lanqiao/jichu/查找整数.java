package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/16 16:57
 **/
public class 查找整数 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        //算法
        for (int i = 0; i < n; i++) {
            if (arr[i] == a) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(- 1);
    }

}

