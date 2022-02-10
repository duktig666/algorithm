package practice;

import java.util.Scanner;

/**
 * description: 小鱼比可爱
 * <p>
 * 人比人，气死人；鱼比鱼，难死鱼。小鱼最近参加了一个“比可爱”比赛，比的是每只鱼的可爱程度。参赛的鱼被从左到右排成一排，
 * 头都朝向左边，然后每只鱼会得到一个整数数值，表示这只鱼的可爱程度，很显然整数越大，表示这只鱼越可爱，而且任意两只鱼的可爱程度可能一样。
 * 由于所有的鱼头都朝向左边，所以每只鱼只能看见在它左边的鱼的可爱程度，它们心里都在计算，在自己的眼力范围内有多少只鱼不如自己可爱呢。
 * 请你帮这些可爱但是鱼脑不够用的小鱼们计算一下。
 * <p>
 * 输入格式
 * 第一行输入一个整数 nn，表示鱼的数目。
 * <p>
 * 第二行内输入 nn 个整数，用空格间隔，依次表示从左到右每只小鱼的可爱程度。
 * <p>
 * 输出格式
 * 行内输出 nn 个整数，用空格间隔，依次表示每只小鱼眼中有多少只鱼不如自己可爱。
 * <p>
 * 输入输出样例
 * 输入 #1复制
 * 6
 * 4 3 0 5 1 2
 * <p>
 * 输出 #1复制
 * 0 0 0 3 1 2
 * <p>
 * 说明/提示
 * 对于 100\%100% 的数据，n\leq 100n≤100。
 *
 * @author RenShiWei
 * Date: 2022/2/10 8:43
 **/
public class 小鱼比可爱 {

    /**
     * output: 一个数组，当前元素左边有几个值比自己小
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrIn = new int[n];
        for (int i = 0; i < n; i++) {
            arrIn[i] = sc.nextInt();
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arrIn[i] > arrIn[j]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }

    }


}

