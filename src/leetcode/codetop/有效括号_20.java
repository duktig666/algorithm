package leetcode.codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description:https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author RenShiWei
 * Date: 2021/12/18 10:41
 **/
public class 有效括号_20 {

    /**
     * 思路：
     * 1. 括号问题，典型的需要利用 栈 来解决问题的场景
     * 2. 遍历字符串
     * 2.1 遇到左括号，加入到栈当中
     * 2.2 遇到右括号，转换为左括号，与栈顶元素对比；相同出栈，不同返回false
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 匹配到有括号，并且括号匹配是 出栈
                if (! stack.isEmpty() && leafOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 将右括号转换为对应的左括号
     */
    private char leafOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        }
        return '[';
    }

}

