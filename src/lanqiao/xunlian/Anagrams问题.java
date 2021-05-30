package lanqiao.xunlian;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 功能描述：在这两个单词当中，每一个英文字母（不区分大小写）所出现的次数都是相同的
 *
 * @author RenShiWei
 * Date: 2020/6/5 15:37
 **/
public class Anagrams问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if (str1.length() != str2.length()) {
            System.out.println("N");
        } else {
            solve(getMap(str1), getMap(str2));
        }
    }

    /**
     *  传入字符串，使用map统计每个字符出现的次数
     * @param str 传入的字符串
     * @return 处理后的map
     */
    public static Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            c = c < 97 ? (char) (c + 32) : c;
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void solve(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char c : map1.keySet()) {
            if (! map1.get(c).equals(map2.get(c))) {
                System.out.println("N");
                return;
            }
        }
        System.out.println("Y");
    }


    /*
        方法二：利用数组索引对应的字符，扫描两个字符，最后扫描数组若有非0的值，说明两个字符串不符合
     */
    public static void solve2() {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next().toLowerCase(); // 将输入单词全部转换为小写
        String word2 = sc.next().toLowerCase();
        int[] helper = new int[128];  // 辅助数组，存储单词对应ASCII对应数字
        if (word1.length() != word2.length()) {  // 单词长度不同，直接返回 N
            System.out.println("N");
            return;
        }
        for (int i = 0; i < word1.length(); i++) {
            char a = word1.charAt(i);
            helper[a] += 1;  //对应辅助数组指针位置数 +1
            char b = word2.charAt(i);
            helper[b] -= 1;  // 对应辅助数组指针位置数 -1
        }
        for (int i = 0; i < helper.length; i++) { // 扫描数组
            if (helper[i] != 0) {
                System.out.println("N");
                return;
            }
        }
        System.out.println("Y");
    }

}

