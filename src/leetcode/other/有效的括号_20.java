package leetcode.other;

import java.util.Stack;

/**
 * description:https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author RenShiWei
 * Date: 2021/12/1 19:54
 **/
public class 有效的括号_20 {

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else { // 字符 c 是右括号
                if (! left.empty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

    char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }

}

