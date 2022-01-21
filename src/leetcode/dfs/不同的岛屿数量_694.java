package leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 题⽬还是输⼊⼀个⼆维矩阵，0 表示海⽔，1 表示陆地，这次让你计算不同的 (distinct) 岛屿数量
 *
 * @author RenShiWei
 * Date: 2022/1/20 21:40
 **/
public class 不同的岛屿数量_694 {

    /** 海洋 */
    final int OCEAN = 0;
    /** 未遍历过的岛屿 */
    final int LAND = 1;
    /** 已遍历过的岛屿 */
    final int LAND_SEARCHED = 2;

    /**
     * 主函数
     * HashSet记录岛屿的序列化，去重，统计个数
     */
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        Set<String> lands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的⽅向可以随便写，不影响正确性
                    dfs(grid, i, j, sb, 666);
                    lands.add(sb.toString());
                }
            }
        }
        // 不相同的岛屿数量
        return lands.size();
    }

    /**
     * 将岛屿遍历，转为序列化字符串 上（1） 下（2） 左（3） 右（4）
     *
     * @param grid 岛屿
     * @param r    /
     * @param c    /
     * @param sb   岛屿序列化字符串
     * @param dir  方向
     */
    private void dfs(int[][] grid, int r, int c, StringBuilder sb, int dir) {
        // 不在网格直接返回
        if (! inArea(grid, r, c)) {
            return;
        }
        // 不是陆地直接返回
        if (grid[r][c] != LAND) {
            return;
        }
        // 遍历过的格子 置为 2
        grid[r][c] = LAND_SEARCHED;

        sb.append(dir).append(',');

        // 上
        dfs(grid, r - 1, c, sb, 1);
        // 下
        dfs(grid, r + 1, c, sb, 2);
        // 左
        dfs(grid, r, c - 1, sb, 3);
        // 右
        dfs(grid, r, c + 1, sb, 4);

        // 后序遍历位置：离开 (i, j)
        sb.append(- dir).append(',');
    }

    /**
     * 判断是否在网格当中
     */
    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;
    }

}
