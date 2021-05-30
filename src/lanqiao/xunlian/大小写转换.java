package lanqiao.xunlian;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/5/29 16:00
 **/
public class 大小写转换 {

    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 'a') {
                arr[i] += 32;
            } else {
                arr[i] -= 32;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}

