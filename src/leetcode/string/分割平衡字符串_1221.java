package leetcode.string;

import org.junit.Test;

/**
 * description:https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * 贪心算法，字符串
 *
 * @author RenShiWei
 * Date: 2021/5/5 14:36
 **/
public class 分割平衡字符串_1221 {

    /**
     * 前言：虽然是一道简单的字符串的题，但是比别的简单题还是费事了些，思考了有一会才想出来解决方法
     * <p>
     * 方法一：暴力破解——字符串截取扫描法
     * <p>
     * 从题中可以得知，平衡字符串有几个条件：
     * ①是字符串的子串，并且按顺序分割成完整的几个子串
     * ②每个子串达到最小的平衡，即L和R的数量相等（并不要求对称）
     * <p>
     * 思路：
     * ①字符串截取，每次多截取两个字符（单数字符串肯定不是平衡字符串），设置两个指针start和end进行截取
     * ②对子串进行遍历，如果L和R的数量相等则满足。start=end，end+2
     * ③不满足的起点不变，做截取两个字符，再次进行遍历。end+2
     * <p>
     * 效率分析：
     * 时间复杂度和空间复杂度都比较高
     */
    public int balancedStringSplit(String s) {
        int sum = 0;
        int start = 0;
        int end = start + 2;
        while (end <= s.length()) {
            char[] chars = s.substring(start, end).toCharArray();
            int lCount = 0, rCount = 0;
            for (char aChar : chars) {
                if (aChar == 'L') {
                    lCount++;
                } else if (aChar == 'R') {
                    rCount++;
                }
            }
            if (lCount == rCount) {
                sum++;
                start = end;
            }
            end += 2;

        }
        return sum;
    }

    /**
     * 顺次扫描法：
     * 如果第一个字符是L，lCount++；如果字符是R，rCount++；如果lCount==rCount,说明找到了一个平衡字符串，sum++
     */
    public int balancedStringSplit1(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int lCount = 0, rCount = 0;
        for (char aChar : chars) {
            if (aChar == 'L') {
                lCount++;
            } else if (aChar == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * leetcode题解：基本和上述我写的顺序扫描一致，只是判定方法不同
     * 使用s.charAt方法，比字符串转换成字符数组在空间占用上少了一些
     */
    public int balancedStringSplit2(String s) {
        int num = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                sum++;
            }
        }
        return sum;
    }


    @Test
    public void test() {
        System.out.println("---方法一——暴力破解（字符串截取扫描法）测试用例---");
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println("---方法二——顺次扫描法 测试用例---");
        System.out.println(balancedStringSplit1("RLRRLLRLRL"));
        System.out.println(balancedStringSplit1("RLLLLRRRLR"));
        System.out.println(balancedStringSplit1("LLLLRRRR"));
        System.out.println(balancedStringSplit1("RLRRRLLRLL"));
    }

}

