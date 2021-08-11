package interview;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description:德衍睿通（2021.08.11）面试算法题，字符串相关
 * <p>
 * 算法题1：随机一个字符串，输出出现次数最多的字符和出现次数
 * 算法题2：随机一个字符串，输出出现的第一个不重复的字符
 *
 * @author RenShiWei
 * Date: 2021/8/11 11:01
 **/
public class RepetitionString20210811 {

    /**
     * 思路1：
     * 扫描字符串，字符为键，次数为值，作统计 还需要比较（定义最大次数记录字符和次数）
     * 思路2：
     * 字符转ASCII码，用数组索引来解决
     *
     * @param str 随机字符
     */
    static void test(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            //字符出现次数统计
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        //遍历取最大值
        //Char最小值
        Character maxKey = '0';
        Integer maxValue = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        System.out.println(maxKey);
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        test("aabc");
        test("abc");
        test("aabbcc");
        test("gghjjaaaaaaaaabclopjlfggsh");
    }

    /**
     * 找出第一个不重复的字符
     * a a b b c d d d e
     * 思路1：遍历一遍必不可少，LinkedHashMap统计次数（保证插入有序），再次遍历到第一个次数为1，即为第一个不重复的字符
     *
     * @param str 随机字符串
     */
    void test2(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            //字符出现次数统计
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }

    @Test
    public void testStr() {
        test2("aaacbbb");
        test2("aaaaaaaaaabbbbbbzbbbbbbbbbaaaaaaaddddd" +
                "----------dddddaaaahhhhhh000000000uuuuuuuuuuuuuuuuuuuu0000000000hhhhhhhhhaaaagggggggggg" +
                "-----------------gaaaaaaaaaaaaaaaaaaaalllllllllllllllaaaaaaaaaaaaaacbbbefffghhh");
        test2("cbbb");
        test2("bbb");
        test2("");
    }

    @Test
    public void testStr2() {
        Map<String, String> mp = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            mp.put("key" + i, "value" + i);
        }
        for (Map.Entry<String, String> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

}

