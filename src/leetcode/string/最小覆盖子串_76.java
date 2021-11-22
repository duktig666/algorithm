package leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/11/22 15:56
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class 最小覆盖子串_76 {

    /**
     * 滑动窗⼝解决
     */
    public String minWindow(String s, String t) {
        // needs代表t中字符出现次数，window代表窗口中相应字符出现的次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        // 将t对应字符及次数存储到map
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 左右指针
        int left = 0, right = 0;
        // valid 变量表示窗⼝中满⾜ need 条件的字符个数；如果 valid 和 need.size 的⼤⼩相同，则说明窗⼝已满⾜条件，已经完全覆盖了串 T
        int valid = 0;
        // 记录最⼩覆盖⼦串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移⼊窗⼝的字符
            char c = s.charAt(right);
            // 右移窗⼝
            right++;
            /* 进⾏窗⼝内数据的⼀系列更新 */
            // 更新当前窗口的字符数量
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    // 窗口中字符出现的次数 等于
                    valid++;
                }
            }

            // 判断左侧窗⼝是否要收缩，到达这里时，刚好找到可行子串，接下来找最小的子串即可
            while (valid == need.size()) {
                // 在这⾥更新最⼩覆盖⼦串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗⼝的字符
                char d = s.charAt(left);
                // 左移窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最⼩覆盖⼦串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}

