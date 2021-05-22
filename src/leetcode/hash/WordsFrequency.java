package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * description:面试题 16.02. 单词频率
 * https://leetcode-cn.com/problems/words-frequency-lcci/
 *
 * @author RenShiWei
 * Date: 2021/5/22 8:27
 **/
public class WordsFrequency {

    /*
     * Your WordsFrequency object will be instantiated and called as such:
     * WordsFrequency obj = new WordsFrequency(book);
     * int param_1 = obj.get(word);
     */

    Map<String, Integer> map;

    /**
     * map put方法操作替代
     * 旧代码：
     * if (map.containsKey(s)) {
     * map.put(s, map.get(s) + 1);
     * } else {
     * map.put(s, 1);
     * }
     * <p>
     * 新代码
     * map.put(s, map.getOrDefault(s, 0) + 1);
     * <p>
     * Map.getOrDefault(Object key, V defaultValue)方法的作用是：
     *   当Map集合中有这个key时，就使用这个key值；
     *   如果没有就使用默认值defaultValue。
     */
    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    /**
     * 旧代码：
     * if (map.containsKey(word)) {
     * return map.get(word);
     * }
     * return 0;
     * <p>
     * 新代码：
     * return map.getOrDefault(word, 0);
     */
    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[] {"i", "have", "an", "apple", "he", "have", "a"
                , "pen"});
        //返回0，"you"没有出现过
        System.out.println(wordsFrequency.get("you"));
        //返回2，"have"出现2次
        System.out.println(wordsFrequency.get("have"));
        //返回1
        System.out.println(wordsFrequency.get("an"));
        //返回1
        System.out.println(wordsFrequency.get("apple"));
        //返回1
        System.out.println(wordsFrequency.get("pen"));
    }

}

