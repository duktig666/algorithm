package practice.marathon;

import java.util.Scanner;

/**
 * description:
 * 链接：https://ac.nowcoder.com/acm/contest/18874/1006
 * 来源：牛客网
 * <p>
 * 题目描述
 * 输入长方体的长、宽、高，计算它的表面积和体积
 * <p>
 * <p>
 * 输入描述:
 * 输入一行，三个整数a,b,c，以空格隔开，分别表示长宽高。
 * <p>
 * 0 <= a, b,c <= 1000
 * 输出描述:
 * 输出两行，每行一个整数，分别表示表面积和体积
 * 示例1
 * 输入
 * 复制
 * 1 1 1
 * 输出
 * 复制
 * 6
 * 1
 *
 * @author RenShiWei
 * Date: 2021/7/30 21:34
 **/
public class Cuboid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println((a * b + a * c + b * c) * 2);
        System.out.println(a * b * c);
    }

}

