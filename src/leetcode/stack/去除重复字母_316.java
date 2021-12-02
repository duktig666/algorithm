package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description:https://leetcode-cn.com/problems/remove-duplicate-letters/
 * <p>
 * 要求一、**要去重**。
 * 要求二、去重字符串中的字符顺序**不能打乱`s`中字符出现的相对顺序**。
 * 要求三、在所有符合上一条要求的去重字符串中，**字典序最小**的作为最终结果。
 * 上述三条要求中，要求三可能有点难理解，举个例子。
 * 比如说输入字符串`s = "babc"`，去重且符合相对位置的字符串有两个，分别是`"bac"`和`"abc"`，但是我们的算法得返回`"abc"`，因为它的字典序更小。
 *
 * @author RenShiWei
 * Date: 2021/12/2 10:54
 **/
public class 去除重复字母_316 {

    /**
     * 用栈实现 要求一和要求二
     */
    public String removeDuplicateLettersTemp(String s) {
        // 存放去重的结果
        Deque<Character> stk = new LinkedList<>();
        // 布尔数组初始值为 false，记录栈中是否存在某个字符
        // 输入字符均为 ASCII 字符，所以大小 256 够用了
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            // 如果字符 c 存在栈中，直接跳过
            if (inStack[c]) {
                continue;
            }
            // 若不存在，则插入栈顶并标记为存在
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (! stk.isEmpty()) {
            sb.append(stk.pop());
        }
        // 栈中元素插入顺序是反的，需要 reverse 一下
        return sb.reverse().toString();
    }

    /**
     * 保证"bcabc"，去重后为"abc"，而不是"bca"。满足要求三
     * 但是存在问题，如果是"bcac"，这个解法会有问题
     */
    private String removeDuplicateLetters2(String s) {
        Deque<Character> stk = new LinkedList<>();
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            if (inStack[c]) {
                continue;
            }

            // 插入之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop 前面的元素
            while (! stk.isEmpty() && stk.peek() > c) {
                // 弹出栈顶元素，并把该元素标记为不在栈中
                inStack[stk.pop()] = false;
            }

            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (! stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 满足所有要求的答案
     */
    public String removeDuplicateLetters(String s) {
        Deque<Character> stk = new LinkedList<>();

        // 维护一个计数器记录字符串中字符的数量，因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) {
                continue;
            }

            while (! stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (! stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }


}

