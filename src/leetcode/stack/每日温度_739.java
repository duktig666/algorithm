package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description:https://leetcode-cn.com/problems/daily-temperatures/
 * <p>
 * Java里面是建议使用Deque替换Stack
 *
 * @author RenShiWei
 * Date: 2021/12/1 21:31
 **/
public class 每日温度_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 构造单调栈
            while (! stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // 得到索引间距
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            // 将索引⼊栈，⽽不是元素
            stack.push(i);
        }
        return res;
    }

}

