package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description:https://leetcode-cn.com/problems/number-of-recent-calls/
 * 933. 最近的请求次数
 * <p>
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 *
 * @author RenShiWei
 * Date: 2021/6/6 17:14
 **/
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        //队首元素不在过去3000ms范围内，出队
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        //返回在范围内的元素个数
        return queue.size();
    }

}

