package lanqiao.jichu;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/16 16:28
 **/
public class 数列特征 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
        while (n-- > 0) {
            //输入每一个数
            int temp = sc.nextInt();
            max = Integer.max(max, temp);
            min = Integer.min(min, temp);
            sum += temp;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);

    }

}

