package lanqiao.zhenti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * description:
 * 蓝桥杯第十届题H
 * 输入
 * 20
 * This is a story about Alice and Bob.Alice wants to send a private message to Bob.
 * 输出
 * 2
 *
 * @author RenShiWei
 * Date: 2020/10/9 9:51
 **/
public class 人物相关性分析 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(str);

        List<Integer> alList = new ArrayList<>();
        List<Integer> boList = new ArrayList<>();
        //统计
        int startIndex = 0;
        while (str.length() > 0) {
            int alIndex = str.indexOf("Alice", startIndex);
            int boIndex = str.indexOf("Bob", startIndex);
            System.out.println(alIndex);
            System.out.println(boIndex);
            //分情况字符串截取，取每次的首位
            if (alIndex != - 1 && boIndex != - 1) {
                boolean beginAl = (alIndex - 1 < 0) || ! check(str.charAt(alIndex - 1));
                boolean endAl = (alIndex + 5 > str.length()) || ! check(str.charAt(alIndex + 5));
                if (beginAl && endAl) {
                    alList.add(alIndex);
                }

                boolean beginBo = (boIndex - 1 < 0) || ! check(str.charAt(boIndex - 1));
                boolean endBo = (boIndex + 3 > str.length()) || ! check(str.charAt(boIndex + 3));
                if (beginBo && endBo) {
                    boList.add(boIndex);
                }
                if (alIndex < boIndex) {
                    startIndex = boIndex + 3;
                } else {
                    startIndex = alIndex + 5;
                }
            } else if (alIndex != - 1) {
                boolean beginAl = (alIndex - 1 < 0) || ! check(str.charAt(alIndex - 1));
                boolean endAl = (alIndex + 5 > str.length()) || ! check(str.charAt(alIndex + 5));
                if (beginAl && endAl) {
                    alList.add(alIndex);
                    startIndex = alIndex + 5;
                }
            } else if (boIndex != - 1) {
                boolean beginBo = (boIndex - 1 < 0) || ! check(str.charAt(boIndex - 1));
                boolean endBo = (boIndex + 3 > str.length()) || ! check(str.charAt(boIndex + 3));
                if (beginBo && endBo) {
                    boList.add(boIndex);
                    startIndex = boIndex + 3;
                }
            }
            //不存在两个子串，跳出循环
            if (alIndex == - 1 && boIndex == - 1) {
                break;
            }
            System.out.println(alList.toString());
            System.out.println(boList.toString());
        }
        int sum = 0;
        //计算次数
        for (int i = 0; i < alList.size(); i++) {
            for (int j = 0; j < boList.size(); j++) {
                if (Math.abs(alList.get(i) - boList.get(j)) <= k) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 检查当前字符是否是字母
     *
     * @param c 字符
     * @return boolean
     */
    static boolean check(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

}

