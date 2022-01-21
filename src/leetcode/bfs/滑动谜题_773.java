package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * description: https://leetcode-cn.com/problems/sliding-puzzle/
 *
 * @author RenShiWei
 * Date: 2022/1/21 16:32
 **/
public class 滑动谜题_773 {

    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();

        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][] {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };

        /* BFS 算法框架开始 */
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // 从起点开始 BFS 搜索
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (! q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                while (Objects.requireNonNull(cur).charAt(idx) != '0') {
                    idx++;
                }

                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    String newBoard = swap(cur.toCharArray(), adj, idx);
                    // 防止走回头路
                    if (! visited.contains(newBoard)) {
                        q.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return - 1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}

