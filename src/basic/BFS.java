package basic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * description: BFS 遍历框架
 *
 * @author RenShiWei
 * Date: 2022/1/21 14:32
 **/
public class BFS {

    /**
     * 题目对应节点
     */
    private class Node {

    }


    /**
     * BFS 遍历框架
     * 计算从起点 start 到终点 target 的最近距离
     *
     * @param start  起点
     * @param target 终点
     * @return 最短距离
     */
    public int BFS(Node start, Node target) {
        // 核心数据结构
        Queue<Node> q = new LinkedList<>();
        // 避免走回头路
        Set<Node> visited = new HashSet<>();

        // 将起点加入队列
        q.offer(start);
        visited.add(start);

        // 记录扩散的步数
        int step = 0;

        while (! q.isEmpty()) {
            int size = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 (根据题意写判断条件）*/
                if (cur == target) {
                    return step;
                }
                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj()) {
//                    // 避免回头
//                    if (! visited.contains(x)) {
//                        q.offer(x);
//                        visited.add(x);
//                    }
//                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }


}

