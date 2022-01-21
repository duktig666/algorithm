package leetcode.bfs;

import java.util.*;

/**
 * description: https://leetcode-cn.com/problems/open-the-lock/
 *
 * @author RenShiWei
 * Date: 2022/1/21 15:17
 **/
public class 打开转盘锁_752 {

    public int openLock(String[] deadends, String target) {
        // 死亡密码
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);

        // 队列 进行BFS 寻找最小次数
        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        // 避免 重复操作
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        // 记录扩散的步数
        int step = 0;

        while (! q.isEmpty()) {
            int size = q.size();
            /* 扩散 */
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                /* 划重点：这里判断是否到达终点 (根据题意写判断条件） */
                if (deads.contains(cur)) {
                    continue;
                }
                if (Objects.requireNonNull(cur).equals(target)) {
                    return step;
                }
                /* 将 cur 的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(cur, j);
                    if (! visited.contains(plusOne)) {
                        q.offer(plusOne);
                        visited.add(plusOne);
                    }
                    String minusOne = minusOne(cur, j);
                    if (! visited.contains(minusOne)) {
                        q.offer(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return - 1;
    }

    /**
     * 将 s[j] 向上拨动一次
     */
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将 s[i] 向下拨动一次
     */
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    // -------------双向 BFS 优化 ---------------------

    /**
     * 双向 bfs
     */
    public int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);

        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;

        q1.add("0000");
        q2.add(target);

        while (! q1.isEmpty() && ! q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (! visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (! visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return - 1;
    }

}

