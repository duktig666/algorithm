package leetcode.codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * description: 3. 无重复字符的最长子串 @see https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author RenShiWei
 * Date: 2021/11/10 9:15
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class codetop3_无重复字符的最长子串_3 {

    /**
     * 滑动窗口
     *
     * @param s 目标字符串
     * @return 最长无重复子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int n = s.length();
        int r = - 1;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            //上一个滑动窗口出现重复元素，移除，重新计算
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 巧妙设计，如果包含了，就不执行 r++ ，保证下次继续从这里执行
            while (r + 1 < n && ! set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }
            maxLength = Math.max(maxLength, r - i + 1);
        }
        return maxLength;
    }

    /**
     * 按照滑动窗口 框架 来写
     */
    public int lengthOfLongestSubstringFrame(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.length()) {
            // c 是将移⼊窗⼝的字符
            char c = s.charAt(right);
            right++;
            // 进⾏窗⼝内数据的⼀系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗⼝是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这⾥更新答案
            res = Integer.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        codetop3_无重复字符的最长子串_3 test = new codetop3_无重复字符的最长子串_3();
        System.out.println(test.lengthOfLongestSubstring("bbbb"));
        System.out.println(test.lengthOfLongestSubstring(""));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("dvdf"));
    }

}

