package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 滑动窗口 框架
 *
 * @author RenShiWei
 * Date: 2021/11/22 15:25
 * blog: https://duktig.cn/
 * github知识库: https://github.com/duktig666/knowledge
 **/
public class SlidingWindow {

    /**
     * 滑动窗⼝算法框架
     */
    public void slidingWindow(String s, String t) {
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
        while (right < s.length()) {
            // c 是将移⼊窗⼝的字符
            char c = s.charAt(right);
            // 右移窗⼝
            right++;
            // 进⾏窗⼝内数据的⼀系列更新

            /* debug 输出的位置 */
            System.out.printf("window: [%d, %d)\n", left, right);

            // 判断左侧窗⼝是否要收缩（条件根据具体题意判断）
            while (left <= right) {
                // d 是将移出窗⼝的字符
                char d = s.charAt(left);
                // 左移窗⼝
                left++;
                // 进⾏窗⼝内数据的⼀系列更新

            }
        }
    }

}

