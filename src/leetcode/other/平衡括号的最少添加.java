package leetcode.other;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/12/1 20:14
 **/
public class 平衡括号的最少添加 {

    /**
     * 921. 使括号有效的最少添加
     * https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
     */
    public int minAddToMakeValid(String s) {
        // res 记录需要括号的插⼊次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 对右括号的需求 + 1
                need++;
            }

            if (s.charAt(i) == ')') {
                // 对右括号的需求 - 1
                need--;
                if (need == - 1) {
                    need = 0;
                    // 需插⼊⼀个左括号
                    res++;
                }
            }
        }
        return res + need;
    }

    /**
     * 1541. 平衡括号字符串的最少插入次数
     * https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string/
     */
    public int minInsertions(String s) {
        // need 记录需右括号的需求量，res为插入括号的数量
        int res = 0, need = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // ⼀个左括号对应两个右括号
                need += 2;
                // 遇到左括号，如果右括号的需求为奇数
                if (need % 2 == 1) {
                    // 插入一个右括号
                    res++;
                    // 有括号的需求-1
                    need--;
                }
            }
            if (s.charAt(i) == ')') {
                need--;
                // 说明右括号太多了
                if (need == - 1) {
                    // 插入一个左括号
                    res++;
                    // 同时需要再插入一个右括号（一个左括号对应两个右括号）
                    need = 1;
                }
            }
        }
        return res + need;
    }

}

