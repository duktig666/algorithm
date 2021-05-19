package leetcode.string;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/find-closest-lcci/
 *
 * @author RenShiWei
 * Date: 2021/5/19 11:18
 **/
public class 单词距离_面试题 {

    /**
     * 方法一：快慢指针
     * 计算两个单词距离，声明一个临时变量，遇到下一个距离小的，直接赋值
     * 难点：快慢指针的移动，牵扯到两个指针指向不同的单词
     * 时间复杂度：O(n)
     */
    public int findClosest(String[] words, String word1, String word2) {
        int fast = 0, slow = 0;
        int distance = words.length;
        while (fast < words.length) {
            if (words[fast].equals(word1) || words[fast].equals(word2)) {
                // slow != 0 排除还未找到两个单词的情况
                if (! words[slow].equals(words[fast]) && slow != 0) {
                    distance = Math.min(distance, fast - slow);
                }
                slow = fast;
            }
            fast++;
        }
        return distance;
    }

    @Test
    public void test() {
        String[] words = new String[] {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        String word1 = "a", word2 = "student";
        System.out.println(findClosest(words, word1, word2));
    }

}

