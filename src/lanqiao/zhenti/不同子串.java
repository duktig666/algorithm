package lanqiao.zhenti;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 第十届蓝桥杯算法省赛  题B
 *
 * @author RenShiWei
 * Date: 2020/10/7 10:08
 **/
public class 不同子串 {

    public static void main(String[] args) {
        System.out.println(getStrSonNum("aaab"));
        System.out.println(getStrSonNum("0100110001010001"));
        test();
    }

    static int getStrSonNum(String str) {
        int len = str.length();
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = str.substring(i, j);
                strSet.add(substring);
            }
        }
        System.out.println(strSet.toString());
        return strSet.size();
    }

    static void test() {
        String s = "0100110001010001";
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        System.out.println(set.size());
    }

}

